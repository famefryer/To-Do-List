package com.example.toDoList.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/todo")
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping
    public List<ToDoItem> retrieveToDoList(){
        List<ToDoItem> todoList = new ArrayList<>();
        toDoRepository.findAll().forEach(todoList::add);
        return todoList;
    }

    @GetMapping(path = "/{id}")
    public ToDoItem findToDoByID(@PathVariable int id){
        Optional<ToDoItem> item = toDoRepository.findById(id);
        if(!item.isPresent()){
            throw new RuntimeException("Post not founded");
        }
        return item.get();
    }

    @PostMapping
    public ResponseEntity<ToDoItem> createToDo(@RequestBody ToDoItem item){
        ToDoItem savedItem = toDoRepository.save(item);
        return new ResponseEntity<ToDoItem>(savedItem, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ToDoItem> updateToDoByID(@PathVariable int id, @RequestBody ToDoItem item){
        Optional<ToDoItem> itemOptional = toDoRepository.findById(id);
        if(!itemOptional.isPresent()){
            throw  new RuntimeException("Post not founded");
        }
        item.setId(id);
        ToDoItem updatedItem = toDoRepository.save(item);
        return new ResponseEntity<ToDoItem>(updatedItem,HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteToDoByID(@PathVariable int id){
        toDoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
