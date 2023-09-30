package com.prospect.manager.domain.services;

import com.prospect.manager.domain.models.Prospect;
import com.prospect.manager.domain.models.QueueItem;
import com.prospect.manager.domain.repositories.QueueItemRepository;
import com.prospect.manager.infrastructure.exception.exceptions.NotFoundException;
import com.prospect.manager.infrastructure.utils.AppModelMapper;
import com.prospect.manager.presentation.dtos.QueueDto;
import com.prospect.manager.presentation.services.IProspectService;
import com.prospect.manager.presentation.services.IQueueService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QueueService implements IQueueService {

    @Autowired
    private QueueItemRepository queueItemRepository;

    @Autowired
    private IProspectService prospectService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertLast(ObjectId prospectId) {
        Prospect prospect = this.prospectService.findById(prospectId);
        QueueItem queueItem = new QueueItem(prospect);
        QueueItem savedQueueItem = this.queueItemRepository.save(queueItem);
        this.linkWithLast(savedQueueItem);
    }

    @Override
    public QueueDto getQueue() {
        List<QueueItem> queueItems = new ArrayList<>();
        this.findFirst()
                .ifPresent(
                        queueItem -> {
                            queueItems.add(queueItem);
                            Optional.ofNullable(queueItem.getNext())
                                    .ifPresent(
                                            next -> this.buildQueue(queueItems, next)
                                    );
                        }
                );
        return AppModelMapper.mapModelToDto(queueItems);
    }

    @Override
    public void onItemUpdate(ObjectId prospectId) {
        this.queueItemRepository.findById(prospectId)
                .ifPresent(this::handleUpdate);
    }

    @Override
    public void onItemDelete(ObjectId prospectId) {
        this.queueItemRepository.findByProspectId(prospectId)
                .ifPresent(this::handleDelete);
    }

    @Override
    public QueueDto removeFirst() {
        QueueItem queueItem = this.findFirst()
                .orElseThrow(() -> new NotFoundException("Fila está vazia"));
        this.queueItemRepository.delete(queueItem);
        return this.getQueue();
    }

    private Optional<QueueItem> findFirst() {
        Query query = new Query()
                .with(Sort.by(Sort.Order.asc("updatedAt")))
                .limit(1);

        return Optional.ofNullable(mongoTemplate.findOne(query, QueueItem.class));
    }

    private void handleUpdate(QueueItem queueItem) {
        this.handleChange(queueItem);
        this.linkWithLast(queueItem);
    }

    private void handleDelete(QueueItem queueItem) {
        this.handleChange(queueItem);
        this.queueItemRepository.delete(queueItem);
    }

    private void handleChange(QueueItem queueItem) {
        Optional<QueueItem> next = this.getNext(queueItem);
        Optional<QueueItem> previous = this.getPrevious(queueItem);
        if(next.isPresent() && previous.isPresent())
            this.linkItems(next.get(), previous.get());
        else if(next.isPresent())
            this.linkWithLast(next.get());
        else if(previous.isPresent()) {
            QueueItem previousItem = previous.get();
            previousItem.clearNext();
            this.queueItemRepository.save(previousItem);
        }
    }

    private void buildQueue(List<QueueItem> queue, ObjectId currentQueueItemId) {
        this.queueItemRepository.findById(currentQueueItemId)
                .ifPresent(
                        queueItem -> {
                            queue.add(queueItem);
                            Optional.ofNullable(queueItem.getNext())
                                            .ifPresent(
                                                    next -> buildQueue(queue, next)
                                            );
                        }
                );
    }

    private void linkWithLast(QueueItem queueItem) {
        this.queueItemRepository.findFirstByNextIsNull()
                .ifPresent(
                        last -> {
                            if(queueItem.getId().equals(last.getId()))
                                this.linkItems(queueItem, last);
                        }
                );
    }

    private void linkItems(QueueItem next, QueueItem previous) {
        previous.setNext(next.getId());
        this.queueItemRepository.save(previous);
    }

    private Optional<QueueItem> getNext(QueueItem queueItem) {
        Optional<QueueItem> optionalQueueItem = Optional.empty();
        if(Optional.ofNullable(queueItem.getNext()).isPresent())
            optionalQueueItem = this.queueItemRepository.findByNext(queueItem.getNext());
        return optionalQueueItem;
    }

    private Optional<QueueItem> getPrevious(QueueItem queueItem) {
        return this.queueItemRepository.findByNext(queueItem.getId());
    }

}
