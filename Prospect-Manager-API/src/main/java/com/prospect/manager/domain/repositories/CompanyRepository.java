package com.prospect.manager.domain.repositories;

import com.prospect.manager.domain.models.Company;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends MongoRepository<Company, ObjectId> {
}
