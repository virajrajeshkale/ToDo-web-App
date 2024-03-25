package com.lcwd.ToDoManager;

import com.lcwd.ToDoManager.Models.Todo;
import com.lcwd.ToDoManager.dao.TodoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;


@SpringBootApplication
public class ToDoManagerApplication  implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(ToDoManagerApplication.class);
	@Autowired
	 private TodoDao  dao;
	public static void main(String[] args) {
		SpringApplication.run(ToDoManagerApplication.class, args);
		System.out.println("Application started..");
	}


	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Now application in run state.....");
//		JdbcTemplate template = dao.getTemplate();
//		logger.info("JDBC TEMPLATE :{}",template);

		//*******testing for insert todo

//		Todo todo = new Todo();
//		todo.setId(23);
//		todo.setTitle("THE ENTREPRENEUR ");
//		todo.setContent("THE STORY OF YOUNG BUSINESS-MAN");
//		todo.setStatus("2 Left");
//		todo.setAddeddate(new Date());
//		todo.setTododate(new Date());
//
//		dao.saveTodo(todo);

		//*****Testing for getting single todo
//		Todo todo = dao.getsingleTodo(2);
//		logger.info("ToDo : {}",todo);

		//******testing for getting all todos

//		List<Todo> allTodos = dao.getAllTodos();
//		logger.info("All ToDo :{}",allTodos);

		//*****Testing for updating single todo
//		Todo todo = dao.getsingleTodo(352);
//		logger.info("ToDo : {}",todo);
//
//		todo.setTitle("Learn spring ");
//		todo.setContent("MASTER SPRING BOOT PROJECT..");
//		todo.setStatus("Available");
//		todo.setAddeddate(new Date());
//		todo.setTododate(new Date());
//
//		dao.updateTodo(352,todo);

		//***Testing to delete todo
//		dao.deleteTodo(352);

		//***testing delete multiple todos
//		dao.deletemultiple(new int []{22,203,232});

	}
}
