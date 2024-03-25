package com.lcwd.ToDoManager.dao;

import com.lcwd.ToDoManager.Helper.Helper;
import com.lcwd.ToDoManager.Models.Todo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
//particular row mapped with todo object
public class ToDoRowMapper implements RowMapper<Todo> {

    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Todo todo = new Todo();
        todo.setId(rs.getInt("id"));
        todo.setTitle(rs.getString("title"));
        todo.setContent(rs.getString("content"));
        todo.setStatus(rs.getString("status"));
        todo.setAddeddate(Helper.pardedate((LocalDateTime) rs.getObject("addeddate")) );
        todo.setTododate(Helper.pardedate((LocalDateTime) rs.getObject("tododate")) );
        return todo;
    }
}
