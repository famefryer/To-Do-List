package com.example.todolist.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDoItem> getToDoList(){
        List<ToDoItem> todoList = new ArrayList<>();
        toDoRepository.findAll().forEach(todoList::add);
        return todoList;
    }

    public ToDoItem findToDoByID(int id){
        Optional<ToDoItem> item = toDoRepository.findById(id);
        if(!item.isPresent()){
            return null;
        }
        return item.get();
    }

    public ToDoItem updateToDoByID(int id, ToDoItem item){
        Optional<ToDoItem> itemOptional = toDoRepository.findById(id);
        if(!itemOptional.isPresent()){
            return null;
        }
        item.setId(id);
        ToDoItem updatedItem = toDoRepository.save(item);
        return updatedItem;
    }

    public boolean deleteToDoByID(int id){
        Optional<ToDoItem> itemOptional = toDoRepository.findById(id);
        if(itemOptional.isPresent()){
            toDoRepository.deleteById(id);
            return true;
        }
        return false;

    }


}
