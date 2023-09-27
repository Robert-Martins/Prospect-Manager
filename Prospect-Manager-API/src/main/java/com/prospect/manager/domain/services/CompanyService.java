package com.prospect.manager.domain.services;

import com.prospect.manager.domain.models.Company;
import com.prospect.manager.domain.repositories.CompanyRepository;
import com.prospect.manager.presentation.dtos.CompanyDto;
import com.prospect.manager.presentation.services.ICompanyService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company create(CompanyDto companyDto) {
        return null;
    }

    @Override
    public Company getById(ObjectId id) {
        return null;
    }

    @Override
    public Company update(CompanyDto companyDto) {
        return null;
    }

    @Override
    public void deleteById(ObjectId id) {

    }

}
