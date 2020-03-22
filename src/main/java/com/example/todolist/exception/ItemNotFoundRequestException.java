package com.example.todolist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundRequestException extends RuntimeException {

    public ItemNotFoundRequestException(String message) {
        super(message);
    }

    public ItemNotFoundRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
