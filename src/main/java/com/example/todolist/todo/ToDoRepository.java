package com.example.todolist.todo;

import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDoItem,Integer> {
}
