package com.lcwd.ToDoManager.Services.impl;

import com.lcwd.ToDoManager.Exception.ResourceNotFoundException;
import com.lcwd.ToDoManager.Models.Todo;
import com.lcwd.ToDoManager.Services.TodoServices;
import com.lcwd.ToDoManager.dao.TodoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class TodoJpaServicesimpl implements TodoServices {
    @Autowired
    private TodoRespository todoRespository;
    @Override
    public Todo createTodo(Todo todo) {
        return todoRespository.save(todo);

    }

    @Override
    public Todo getTodo(int todoid) {
        Todo todo = todoRespository.findById(todoid).orElseThrow(() -> new ResourceNotFoundException("To Do not found",HttpStatus.NOT_FOUND));

        return todo;
    }

    @Override
    public List<Todo> getAllTodos() {
        List<Todo> all = todoRespository.findAll();
        return all;
    }

    @Override
    public Todo updateTodo(int todoId, Todo newtodo) {
        Todo old = todoRespository.findById(todoId).orElseThrow(() -> new ResourceNotFoundException("To Do not found..",HttpStatus.NOT_FOUND));

        old.setTitle(newtodo.getTitle());
        old.setStatus(newtodo.getStatus());
        old.setContent(newtodo.getContent());
        old.setAddeddate(newtodo.getAddeddate());
        old.setTododate(newtodo.getTododate());

        Todo save = todoRespository.save(old);
        return save;
    }

    @Override
    public void deleteTodo(int todoid) {
        Todo todo = todoRespository.findById(todoid).orElseThrow(() -> new ResourceNotFoundException("Todo not found",HttpStatus.NOT_FOUND));
        todoRespository.delete(todo);

    }
}
