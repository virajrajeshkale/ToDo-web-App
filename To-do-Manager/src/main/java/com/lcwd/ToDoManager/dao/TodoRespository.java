package com.lcwd.ToDoManager.dao;

import com.lcwd.ToDoManager.Models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRespository extends JpaRepository<Todo, Integer> {
}
