package com.lcwd.ToDoManager.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@Table(name = "Jpa_todos")
public class Todo {
    @Id
    private  int id;
    @Column(name = "Todo_Title",length = 100)
    private  String title;
    @Column(name = "Todo_Content",length = 500)
    private  String content;
    @Column(name = "Todo_Status",length = 10)
    private  String status;
    @Column(name = "Added_Date")
    private Date  addeddate;

    @Column(name = "Todo_Date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private  Date tododate;

    public Todo(int id, String title, String content, String status,Date addeddate,Date tododate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.addeddate = addeddate;
        this.tododate = tododate;
    }

    public Todo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(Date addeddate) {
        this.addeddate = addeddate;
    }

    public Date getTododate() {
        return tododate;
    }

    public void setTododate(Date tododate) {
        this.tododate = tododate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", addeddate=" + addeddate +
                ", tododate=" + tododate +
                '}';
    }
}
