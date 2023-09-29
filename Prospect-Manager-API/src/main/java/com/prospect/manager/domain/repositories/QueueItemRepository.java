package com.prospect.manager.domain.repositories;

import com.prospect.manager.domain.models.QueueItem;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QueueItemRepository extends MongoRepository<QueueItem, ObjectId> {

    @Query("{'next': null}")
    Optional<QueueItem> findFirstByNextIsNull();

    Optional<QueueItem> findByProspectId(ObjectId prospectId);

    Optional<QueueItem> findByNext(ObjectId next);

}
