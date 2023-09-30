package com.prospect.manager.presentation.services;

import com.prospect.manager.domain.models.Company;
import com.prospect.manager.presentation.dtos.CompanyDto;
import org.bson.types.ObjectId;

public interface ICompanyService {

    Company create(CompanyDto companyDto);

    Company getById(ObjectId id);

    Company update(CompanyDto companyDto);

    void deleteById(ObjectId id);

}
