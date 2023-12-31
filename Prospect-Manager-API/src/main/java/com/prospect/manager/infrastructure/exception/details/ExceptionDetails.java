package com.prospect.manager.infrastructure.exception.details;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionDetails {

    private String title;

    private int status;

    private String details;

    private String developerMessage;

    private String className;

    private LocalDateTime timestamp;

}
