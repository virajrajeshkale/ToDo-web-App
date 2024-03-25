package com.lcwd.ToDoManager.Services;

import com.lcwd.ToDoManager.Models.Todo;

import java.util.List;
//for loose coupling we create interface and call  define their body into another class
//its is important for making any changes with application we can do it easily
public interface TodoServices {
    public Todo createTodo(Todo todo);
    public Todo getTodo(int todoid);
    public List<Todo> getAllTodos();
    public  Todo updateTodo(int todoId , Todo todo);
    public void deleteTodo(int todoid);

}
