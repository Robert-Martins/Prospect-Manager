package com.prospect.manager.domain.models;

import com.prospect.manager.infrastructure.base.BaseEntity;
import com.prospect.manager.infrastructure.enums.ProspectAnalysisStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "prospects")
public class Prospect extends BaseEntity {

    @NotNull
    private ProspectAnalysisStatus status;

    private Date analyzedAt;

    @NotNull
    private Boolean naturalPerson;

    @DBRef
    private Person person;

    @DBRef
    private Company company;

}
