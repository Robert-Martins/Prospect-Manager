package com.prospect.manager.presentation.services;

import com.prospect.manager.domain.models.Person;
import com.prospect.manager.presentation.dtos.PersonDto;
import org.bson.types.ObjectId;

public interface IPersonService {

    Person create(PersonDto personDto);

    Person getById(ObjectId id);

    Person update(PersonDto personDto);

    void deleteById(ObjectId id);

}
