package com.example.todolist.todo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToDoResponse {
    private int code;

    @JsonIgnore
    private HttpStatus status;

    private String message;
    private Object result;

    protected ToDoResponse (){

    }

    public ToDoResponse(HttpStatus status,String message) {
        this.status = status;
        this.code = status.value();
        this.message = message;
    }

    public ToDoResponse(HttpStatus status,String message, Object result) {
        this.status =status;
        this.code = status.value();
        this.message = message;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
