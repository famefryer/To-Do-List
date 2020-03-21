package com.example.toDoList.post;

import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDoItem,Integer> {
}
