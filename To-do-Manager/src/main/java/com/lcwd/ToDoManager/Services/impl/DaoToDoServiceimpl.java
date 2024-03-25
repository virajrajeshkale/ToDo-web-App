package com.lcwd.ToDoManager.Services.impl;

import com.lcwd.ToDoManager.Models.Todo;
import com.lcwd.ToDoManager.Services.TodoServices;
import com.lcwd.ToDoManager.dao.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Primary
public class DaoToDoServiceimpl implements TodoServices {
    @Autowired
    private TodoDao todoDao;
    @Override
    public Todo createTodo(Todo todo) {
        return todoDao.saveTodo(todo);
    }

    @Override
    public Todo getTodo(int todoid) {
        return todoDao.getsingleTodo(todoid);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoDao.getAllTodos();
    }

    @Override
    public Todo updateTodo(int todoId, Todo todo) {
        return todoDao.updateTodo(todoId,todo);
    }

    @Override
    public void deleteTodo(int todoid) {
        todoDao.deleteTodo(todoid);
    }
}
