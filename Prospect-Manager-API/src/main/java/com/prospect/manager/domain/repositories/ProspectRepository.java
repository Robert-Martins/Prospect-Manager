package com.prospect.manager.domain.repositories;

import com.prospect.manager.domain.models.Prospect;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProspectRepository extends MongoRepository<Prospect, ObjectId> {
}
