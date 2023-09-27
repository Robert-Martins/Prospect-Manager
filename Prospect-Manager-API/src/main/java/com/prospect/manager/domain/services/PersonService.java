package com.prospect.manager.domain.services;

import com.prospect.manager.domain.models.Person;
import com.prospect.manager.domain.repositories.PersonRepository;
import com.prospect.manager.presentation.dtos.PersonDto;
import com.prospect.manager.presentation.services.IPersonService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person create(PersonDto personDto) {
        return null;
    }

    @Override
    public Person getById(ObjectId id) {
        return null;
    }

    @Override
    public Person update(PersonDto personDto) {
        return null;
    }

    @Override
    public void deleteById(ObjectId id) {

    }
    
}
