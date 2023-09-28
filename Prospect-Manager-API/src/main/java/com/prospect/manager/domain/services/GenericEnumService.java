package com.prospect.manager.domain.services;

import com.prospect.manager.infrastructure.enums.ProspectAnalysisStatus;
import com.prospect.manager.presentation.dtos.EnumDto;
import com.prospect.manager.presentation.services.IGenericEnumService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GenericEnumService implements IGenericEnumService {

    @Override
    public List<EnumDto> loadEnum(String enumName) {
        return switch (enumName) {
            case "prospectAnalysisStatus" -> Arrays.stream(ProspectAnalysisStatus.values()).map(e -> new EnumDto(e.name(), e.getDescription())).toList();
            default -> new ArrayList<>();
        };
    }

}
