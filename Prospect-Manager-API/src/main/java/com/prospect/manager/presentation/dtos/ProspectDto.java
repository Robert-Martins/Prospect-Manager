package com.prospect.manager.presentation.dtos;

import com.prospect.manager.infrastructure.enums.ProspectAnalysisStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProspectDto {

    private String id;

    private ProspectAnalysisStatus status;

    private Date analyzedAt;

    @NotNull
    private Boolean naturalPerson;

    private PersonDto person;

    private CompanyDto company;

    private Date createdAt;

}
