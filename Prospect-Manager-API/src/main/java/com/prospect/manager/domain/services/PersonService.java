package com.prospect.manager.domain.services;

import com.prospect.manager.domain.models.Person;
import com.prospect.manager.domain.repositories.PersonRepository;
import com.prospect.manager.infrastructure.exception.exceptions.DuplicateKeyException;
import com.prospect.manager.infrastructure.exception.exceptions.NotFoundException;
import com.prospect.manager.presentation.dtos.PersonDto;
import com.prospect.manager.presentation.services.IPersonService;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person create(PersonDto personDto) {
        if(this.personRepository.existsByCpf(personDto.getCpf()))
            throw new DuplicateKeyException("Pessoa com este CPF já existe");
        Person person = new Person();
        BeanUtils.copyProperties(personDto, person,
                "id",
                "createdAt",
                "updatedAt");
        return this.personRepository.save(person);
    }

    @Override
    public Person getById(ObjectId id) {
        return this.personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pessoa não foi encontrada"));
    }

    @Override
    public Person update(PersonDto personDto) {
        Person person = this.personRepository.findById(new ObjectId(personDto.getId()))
                .orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));
        if(!person.getCpf().equalsIgnoreCase(personDto.getCpf()) && this.personRepository.existsByCpf(personDto.getCpf()))
            throw new DuplicateKeyException("Pessoa com este CPF já existe");
        BeanUtils.copyProperties(personDto, person,
                "id",
                "createdAt",
                "updatedAt");
        return person;
    }

    @Override
    public void deleteById(ObjectId id) {
        if(!this.personRepository.existsById(id))
            throw new NotFoundException("Pessoa não encontrada");
        this.personRepository.deleteById(id);
    }

}
