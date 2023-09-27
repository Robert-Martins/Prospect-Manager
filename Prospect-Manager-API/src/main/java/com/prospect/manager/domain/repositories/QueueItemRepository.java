package com.prospect.manager.domain.repositories;

import com.prospect.manager.domain.models.QueueItem;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueItemRepository extends MongoRepository<QueueItem, ObjectId> {
}
