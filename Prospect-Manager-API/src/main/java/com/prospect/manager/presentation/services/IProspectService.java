package com.prospect.manager.presentation.services;

import com.prospect.manager.infrastructure.filters.ProspectFilter;
import com.prospect.manager.presentation.dtos.ProspectDto;
import org.bson.types.ObjectId;

import java.util.List;

public interface IProspectService {

    void create(ProspectDto prospectDto);

    ProspectDto read(ObjectId id);

    List<ProspectDto> readAll(ProspectFilter prospectFilter);

    void update(ProspectDto prospectDto);

    void delete(ObjectId id);

    String existsByTaxId(String taxId);

    void analyze(ObjectId id);

}
