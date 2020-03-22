package com.example.todolist.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {
    private final Integer code;

    @JsonIgnore
    private final HttpStatus status;

    private final String message;
    private final ZonedDateTime timestamp;

    public ApiException(int code, String message, HttpStatus status, ZonedDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public Integer getCode() {
        return code;
    }
}
