package com.example.todolist.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String BANGKOK_ZONE_ID = "Asia/Bangkok";

    @ExceptionHandler(value = ItemNotFoundRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ItemNotFoundRequestException e){
        ApiException apiException = new ApiException(HttpStatus.NOT_FOUND.value(),e.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now(ZoneId.of(BANGKOK_ZONE_ID)));
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiException apiException = new ApiException(status.value(),"Invalid argument",status, ZonedDateTime.now(ZoneId.of(BANGKOK_ZONE_ID)));
        return new ResponseEntity<>(apiException,status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiException apiException = new ApiException(status.value(),"Invalid path or Http request method",status, ZonedDateTime.now(ZoneId.of(BANGKOK_ZONE_ID)));
        return new ResponseEntity<>(apiException,status);
    }
}
