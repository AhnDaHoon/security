package com.in28.learnspringsecurity.basic;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {


    public static final List<Todo> TODOS_LIST = List.of(new Todo("asd13", "learn AWS"), new Todo("asd13", "get AWS"));

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos(){
        return TODOS_LIST;
    }
    @GetMapping("/users/{username}/todos")
    public Todo retrieveAllTodosForSpecificUser(@PathVariable String username){
        return TODOS_LIST.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodoForSpecificUser(@PathVariable String username, @RequestBody Todo todo){
        System.out.printf("Create {} for {}", todo, username);
    }

}

record Todo(String username, String description){}
