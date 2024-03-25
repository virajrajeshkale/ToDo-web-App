package com.lcwd.ToDoManager.Controllers;

import com.lcwd.ToDoManager.Models.Todo;
import com.lcwd.ToDoManager.Services.TodoServices;
import com.lcwd.ToDoManager.Services.impl.TodoServicesimpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class TodoController {
        Logger logger = LoggerFactory.getLogger(TodoController.class);

        //generate automatic id
        Random random = new Random();




       @Autowired
        private TodoServices todoServices;
        @PostMapping
        public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo)
        {
//            String x =null;
//            int n = x.length();
            int id  = random.nextInt(9999999);

            //create date
            Date currentdate = new Date();
            logger.info("Current Date : {}",currentdate);

            logger.info("To Do Date : {}",todo.getTododate());

            todo.setAddeddate(currentdate);
            todo.setId(id);
                logger.info("Created todo");
           Todo todo1 = todoServices.createTodo(todo);
           return  new ResponseEntity<>(todo1, HttpStatus.CREATED);
        }

        //******get all todods

    @GetMapping
    public ResponseEntity <List<Todo>> getAllTodoHandler()
    {
        List<Todo> allTodos = todoServices.getAllTodos();
        return  new ResponseEntity<>(allTodos,HttpStatus.OK);
    }

    //**** get single todo

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getSingleTodoHandler(@PathVariable("todoId") int todoid)
    {
        Todo todo = todoServices.getTodo(todoid);
        return  ResponseEntity.ok(todo);
    }

    //update todo by using  id
    @PutMapping("/{todoId}")
    public  ResponseEntity<Todo> updateTodoHandler(@RequestBody Todo todowithupdateddeatails,@PathVariable("todoId") int todoId)
    {
       Todo todo =  todoServices.updateTodo(todoId,todowithupdateddeatails);
       return ResponseEntity.ok(todo);

    }

    //delete tod
    @DeleteMapping("/{todoId}")
    public  ResponseEntity<String> deleteTodoHandler(@PathVariable("todoId") int todoid)
    {
        logger.info("ToDo deleted successfully..");
        todoServices.deleteTodo(todoid);
        return  ResponseEntity.ok("Todo Successfully deleted....");
    }

//    @ExceptionHandler(NullPointerException.class)
//    public  ResponseEntity<String> nullpointerExceptionHandler(NullPointerException ex)
//    {
//        System.out.println(" Exception : "+ex.getMessage());
//        return  ResponseEntity.internalServerError("Exception :"+ex.getMessage());
//    }
}
