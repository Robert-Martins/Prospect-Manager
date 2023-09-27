package com.prospect.manager.domain.models;

import com.prospect.manager.infrastructure.base.BaseEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "companies")
public class Company extends BaseEntity {

    @NotNull(message = "CNPJ Field is Null")
    @Size(min = 14, max = 14, message = "CNPJ Field with more or less than 14 characters")
    private String cnpj;

    @NotNull(message = "Name Field is Null")
    @Size(max = 50, message = "Name Field with more than 50 characters")
    private String name;

    @Max(value = 9999, message = "MCC Field with value higher than 9999")
    private Integer mcc;

    @DBRef
    private Person contact;

    @DBRef
    private Prospect prospect;

}
