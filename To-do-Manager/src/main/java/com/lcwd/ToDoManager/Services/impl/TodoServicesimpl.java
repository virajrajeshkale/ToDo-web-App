package com.lcwd.ToDoManager.Services.impl;

import com.lcwd.ToDoManager.Exception.ResourceNotFoundException;
import com.lcwd.ToDoManager.Models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoServicesimpl implements com.lcwd.ToDoManager.Services.TodoServices {

    Logger logger = LoggerFactory.getLogger(TodoServicesimpl.class);

    List<Todo> todos = new ArrayList<>();
    public Todo  createTodo(Todo todo)
    {
        todos.add(todo);
        logger.info("Todo {} ",this.todos);
        return todo;
    }

    public List<Todo> getAllTodos() {
        return todos;
    }

    public Todo getTodo(int todoid) {
      Todo todo  = todos.stream().filter(t -> todoid ==t.getId()).findAny().orElseThrow(()-> new ResourceNotFoundException("Todo Not found with given ID", HttpStatus.NOT_FOUND));
        logger.info("ToDo : {}",todo);
        return todo;
    }

    public  Todo updateTodo(int todoId , Todo todo)
    {
       List<Todo> newupdatedlist =  todos.stream().map(t->
        {
            if(t.getId()==todoId)
            {
                //update to
                    t.setTitle(todo.getTitle());
                    t.setContent(todo.getContent());
                    t.setStatus(todo.getStatus());

                return t;
            }else
            {
                return t;
            }
        }).collect(Collectors.toList());
       todos = newupdatedlist;
       todo.setId(todoId);
       return todo;
    }

    public void deleteTodo(int todoid) {
        List<Todo> newTodoList = todos.stream().filter(t->t.getId()!=todoid).collect(Collectors.toList());
        todos = newTodoList;
    }
}
