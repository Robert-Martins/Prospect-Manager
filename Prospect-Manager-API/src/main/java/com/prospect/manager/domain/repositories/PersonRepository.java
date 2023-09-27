package com.prospect.manager.domain.repositories;

import com.prospect.manager.domain.models.Person;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, ObjectId> {

    Boolean existsByCpf(String cpf);

}
