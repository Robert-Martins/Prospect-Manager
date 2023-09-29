package com.prospect.manager.presentation.services;

import com.prospect.manager.domain.models.Prospect;
import com.prospect.manager.infrastructure.enums.ProspectAnalysisStatus;
import com.prospect.manager.infrastructure.filters.ProspectFilter;
import com.prospect.manager.presentation.dtos.ProspectDto;
import org.bson.types.ObjectId;

import java.util.List;

public interface IProspectService {

    void create(ProspectDto prospectDto);

    Prospect findById(ObjectId id);

    ProspectDto read(ObjectId id);

    List<ProspectDto> readAll(ProspectFilter prospectFilter);

    void update(ProspectDto prospectDto);

    void delete(Prospect prospect);

    void deleteById(ObjectId id);

    void analyze(ObjectId id, ProspectAnalysisStatus status);

}
