package com.prospect.manager.domain.services;

import com.prospect.manager.domain.models.Company;
import com.prospect.manager.domain.repositories.CompanyRepository;
import com.prospect.manager.infrastructure.exception.exceptions.DuplicateKeyException;
import com.prospect.manager.infrastructure.exception.exceptions.NotFoundException;
import com.prospect.manager.presentation.dtos.CompanyDto;
import com.prospect.manager.presentation.services.ICompanyService;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PersonService personService;

    @Override
    public Company create(CompanyDto companyDto) {
        if(this.companyRepository.existsByCnpj(companyDto.getCnpj()))
            throw new DuplicateKeyException("Empresa com este CPNJ já existe");
        Company company = new Company();
        Optional.ofNullable(companyDto.getPersonDto())
                        .ifPresent(
                                personDto -> company.setContact(this.personService.create(personDto))
                        );
        BeanUtils.copyProperties(companyDto, company,
                "id",
                "createdAt",
                "updatedAt");
        return this.companyRepository.save(company);
    }

    @Override
    public Company getById(ObjectId id) {
        return this.companyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Empresa não encontrada"));
    }

    @Override
    public Company update(CompanyDto companyDto) {
        Company company = this.companyRepository.findById(new ObjectId(companyDto.getId()))
                .orElseThrow(() -> new NotFoundException("Empresa não encontrada"));
        if(this.companyRepository.existsByCnpj(companyDto.getCnpj()))
            throw new DuplicateKeyException("Empresa com este CPNJ já existe");
        Optional.ofNullable(companyDto.getPersonDto())
                .ifPresent(
                        personDto -> company.setContact(this.personService.update(personDto))
                );
        BeanUtils.copyProperties(companyDto, company,
                "id",
                "createdAt",
                "updatedAt");
        return this.companyRepository.save(company);
    }

    @Override
    public void deleteById(ObjectId id) {
        if(!this.companyRepository.existsById(id))
            throw new NotFoundException("Empresa não encontrada");
        this.companyRepository.deleteById(id);
    }

}
