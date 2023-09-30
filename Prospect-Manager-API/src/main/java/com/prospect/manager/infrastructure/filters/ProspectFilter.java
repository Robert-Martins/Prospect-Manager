package com.prospect.manager.infrastructure.filters;

import com.prospect.manager.infrastructure.enums.ProspectAnalysisStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProspectFilter {

    private String name;

    private String taxId;

    private Integer mcc;

    private ProspectAnalysisStatus status;

    private Boolean naturalPerson;

    private Date initialDate;

    private Date finalDate;

}
