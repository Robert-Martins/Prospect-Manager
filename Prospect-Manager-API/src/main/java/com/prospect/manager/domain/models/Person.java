package com.prospect.manager.domain.models;

import com.prospect.manager.infrastructure.base.BaseEntity;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "persons")
public class Person extends BaseEntity {

    @NotNull(message = "CPF Field is Null")
    @Size(min = 11, max = 11, message = "CPF Field with more or less than 11 characters")
    private String cpf;

    @NotNull(message = "Name Field is Null")
    @Size(max = 50, message = "Name Field with more than 50 characters")
    private String name;

    @NotNull(message = "Email Field is Null")
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
    private String email;

    @Max(value = 9999, message = "MCC Field with value higher than 9999")
    private Integer mcc;

    @DBRef
    private Prospect prospect;

}
