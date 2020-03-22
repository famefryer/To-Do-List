package com.example.todolist.todo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class ToDoItem {

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    protected ToDoItem() {
    }

    public ToDoItem(@NotEmpty String name, @NotEmpty String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
