package com.prospect.manager.presentation.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProspectDto {

    private String id;

    @NotNull
    private Boolean analyzed;

    @NotNull
    private Boolean naturalPerson;

    private PersonDto person;

    private CompanyDto company;

    private Date createdAt;

}
