package com.prospect.manager.presentation.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDto {

    private String id;

    private String cnpj;

    private String name;

    private Integer mcc;

    private PersonDto personDto;

}
