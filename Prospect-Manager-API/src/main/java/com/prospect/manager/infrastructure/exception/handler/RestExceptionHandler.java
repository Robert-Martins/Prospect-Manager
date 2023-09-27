package com.prospect.manager.infrastructure.exception.handler;

import com.prospect.manager.infrastructure.exception.details.ExceptionDetails;
import com.prospect.manager.infrastructure.exception.exceptions.DuplicateKeyException;
import com.prospect.manager.infrastructure.exception.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ExceptionDetails> handleDuplicateKeyException(DuplicateKeyException exception){
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Chave Duplicada")
                        .status(HttpStatus.NOT_ACCEPTABLE.value())
                        .details(exception.getMessage())
                        .developerMessage(DuplicateKeyException.EXCEPTION_DEVELOPER_MESSAGE)
                        .className(Arrays.stream(exception.getStackTrace()).findFirst().get().getClassName())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.NOT_ACCEPTABLE
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleNotFoundException(NotFoundException exception){
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Não Encontrado")
                        .status(HttpStatus.NOT_FOUND.value())
                        .details(exception.getMessage())
                        .developerMessage(NotFoundException.EXCEPTION_DEVELOPER_MESSAGE)
                        .className(Arrays.stream(exception.getStackTrace()).findFirst().get().getClassName())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.NOT_FOUND
        );
    }

}
