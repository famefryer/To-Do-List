package com.example.todolist.todo;

import com.example.todolist.exception.ItemNotFoundRequestException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/todo")
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private ToDoService toDoService;

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping
    public ResponseEntity<Object> retrieveToDoList(){
        return ResponseEntity.ok(new ToDoResponse(HttpStatus.OK,"Success to get krub",toDoService.getToDoList()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> findToDoByID(@PathVariable int id){
        ToDoItem item = toDoService.findToDoByID(id);
        if(item == null)
            throw new ItemNotFoundRequestException("TodoItem(Id:"+id+") not founded");
        return ResponseEntity.ok(new ToDoResponse(HttpStatus.OK,"Success Krub",item));
    }

    @PostMapping
    public ResponseEntity<Object> createToDo(@Valid @RequestBody ToDoItem item){
        ToDoItem savedItem = toDoRepository.save(item);
        return new ResponseEntity<Object>(new ToDoResponse(HttpStatus.CREATED,"Success",item),HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updateToDoByID(@PathVariable int id, @Valid @RequestBody ToDoItem item){
        ToDoItem updatedItem = toDoService.updateToDoByID(id,item);
        if(updatedItem == null)
            throw new ItemNotFoundRequestException("TodoItem(Id:"+id+") not founded");
        return ResponseEntity.ok(new ToDoResponse(HttpStatus.OK,"Success",item));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteToDoByID(@PathVariable int id){
        if(toDoService.deleteToDoByID(id)){
            return ResponseEntity.ok(new ToDoResponse(HttpStatus.OK,"Success"));
        }
        throw new ItemNotFoundRequestException("TodoItem(Id:"+id+") not founded");
    }

    @GetMapping(path = "/getFile")
    public ResponseEntity<Object> getFile(){
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream inputStream = loadFile().getInputStream();
            String text = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
            return ResponseEntity.ok(new ToDoResponse(HttpStatus.OK, "Success to get file : "+ text));
        } catch (Exception e) {
            return ResponseEntity.ok(new ToDoResponse(HttpStatus.OK, "Not found ja"));
        }
    }
    private Resource loadFile(){
        return resourceLoader.getResource("classpath:data/test.txt");
    }


}
