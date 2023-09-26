package com.prospect.manager.domain.models;

import com.prospect.manager.infrastructure.base.BaseEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "prospects")
public class Prospect extends BaseEntity {

    @NotNull
    private Boolean isNaturalPerson;

    @DBRef
    private Person person;

    @DBRef
    private Company company;

}
