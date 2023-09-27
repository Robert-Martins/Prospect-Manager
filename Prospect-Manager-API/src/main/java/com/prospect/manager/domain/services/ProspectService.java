package com.prospect.manager.domain.services;

import com.prospect.manager.domain.repositories.ProspectRepository;
import com.prospect.manager.infrastructure.filters.ProspectFilter;
import com.prospect.manager.presentation.dtos.ProspectDto;
import com.prospect.manager.presentation.services.IProspectService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProspectService implements IProspectService {

    @Autowired
    private ProspectRepository prospectRepository;

    public void create(ProspectDto prospectDto) {

    }

    public ProspectDto read(ObjectId id) {

    }

    public List<ProspectDto> readAll(ProspectFilter prospectFilter) {

    }

    public void update(ProspectDto prospectDto) {

    }

    public void delete(ObjectId id) {

    }

    public String existsByTaxId(String taxId) {

    }

    public void analyze(ObjectId id) {

    }

}
