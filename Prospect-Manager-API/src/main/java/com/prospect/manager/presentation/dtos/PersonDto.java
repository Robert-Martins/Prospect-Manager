package com.prospect.manager.presentation.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto {

    private String id;

    @NotNull(message = "Name Field is Null")
    @Size(max = 50, message = "Name Field with more than 50 characters")
    private String name;

    @NotNull(message = "CPF Field is Null")
    @Size(min = 11, max = 11, message = "CPF Field with more or less than 11 characters")
    private String cpf;

    @NotNull(message = "Email Field is Null")
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$\n")
    private String email;

    @Max(value = 9999, message = "MCC Field with a value or negative or higher than 9999")
    private Integer mcc;

}
