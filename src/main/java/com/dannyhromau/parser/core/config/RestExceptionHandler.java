package com.dannyhromau.parser.core.config;

import com.dannyhromau.parser.api.dto.ErrorMessageDto;
import com.dannyhromau.parser.exception.InvalidInputDataException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({InvalidInputDataException.class})
    protected ResponseEntity<ErrorMessageDto> conflictHandler(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessageDto(e.getMessage()));
    }
}
