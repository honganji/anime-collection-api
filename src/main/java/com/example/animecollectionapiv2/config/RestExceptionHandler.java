package com.example.animecollectionapiv2.config;

import com.example.animecollectionapiv2.dto.ErrorDto;
import com.example.animecollectionapiv2.exception.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(AppException ex) {
        return ResponseEntity.status(ex.getStatus()).body(new ErrorDto(ex.getMessage()));
    }
}
