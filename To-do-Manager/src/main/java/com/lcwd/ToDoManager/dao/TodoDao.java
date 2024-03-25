package com.lcwd.ToDoManager.dao;

import com.lcwd.ToDoManager.Helper.Helper;
import com.lcwd.ToDoManager.Models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class TodoDao {
    Logger  logger = LoggerFactory.getLogger(TodoDao.class);

    @Autowired
  private   JdbcTemplate template;

    public TodoDao( @Autowired JdbcTemplate template) {
        this.template = template;

        //create table if not exist
        String createtable = "create table IF NOT EXISTS todos (id int primary key,title varchar(150) not null ,content varchar(2000),status varchar(10),addeddate  datetime,tododate datetime )";
        int update = template.update(createtable);
        logger.info("Table Created :{}",update);
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    //save todo in database

    public Todo saveTodo(Todo todo)
    {
        String insertQuery = "insert into  todos(id,title,content,status,addeddate,tododate) values(?,?,?,?,?,?)";
        int update = template.update(insertQuery, todo.getId(), todo.getTitle(), todo.getContent(), todo.getStatus(), todo.getAddeddate(), todo.getTododate());
         logger.info("No of rows affected after To Do save :{}",update);
         return todo;
    }

    //get all todo from database

        public  Todo getsingleTodo(int id)
        {
            String getQuery = "Select * from todos where id = ?";

            Todo todo = template.queryForObject(getQuery, new ToDoRowMapper(), id);

            //*OLD APPROACH*
         //   Map<String, Object> Map = template.queryForMap(getQuery, id);
       //     logger.info("No of todo gets : {}",stringObjectMap);

//            Todo todo = new Todo();
//            todo.setId(((int)Map.get("id")));
//            todo.setTitle(((String) Map.get("title")));
//            todo.setContent(((String) Map.get("content")));
//            todo.setStatus((String) (Map.get("status")));
//            todo.setAddeddate(Helper.pardedate((LocalDateTime) Map.get("addeddate")) );
//            todo.setTododate(Helper.pardedate((LocalDateTime) Map.get("tododate")) );
            return todo;
        }

        //get all todo from database
     public List<Todo> getAllTodos()
     {
         String getAlltodo = "Select * from todos";
         List<Todo> query = template.query(getAlltodo, new ToDoRowMapper());

//         ****** OLD ****
//         List<Map<String, Object>> listmap = template.queryForList(getAlltodo);
//
//         List<Todo> todos = listmap.stream().map((map) ->
//         {
//             Todo todo = new Todo();
//             todo.setId(((int) map.get("id")));
//             todo.setTitle(((String) map.get("title")));
//             todo.setContent(((String) map.get("content")));
//             todo.setStatus((String) (map.get("status")));
//
//             todo.setAddeddate(Helper.pardedate((LocalDateTime) map.get("addeddate")));
//             todo.setTododate(Helper.pardedate((LocalDateTime) map.get("tododate")));
//             return todo;
//         }).collect(Collectors.toList());

         return query;
     }

    //update todo
        public  Todo updateTodo(int id,Todo newtodo)
        {

            String updatequery = "update todos set  title = ? , content=?,status=?,addeddate=?,tododate=? where id = ?";
            int update = template.update(updatequery, newtodo.getTitle(), newtodo.getContent(), newtodo.getStatus(), newtodo.getAddeddate(), newtodo.getTododate(), id);
            logger.info("UPDATED:{}",update);
            newtodo.setId(id);
            return  newtodo;
        }


    //delete todo from database
    public void deleteTodo(int id)
    {
        String deleteQuery = "delete from todos where id = ?";
        int update = template.update(deleteQuery, id);
        logger.info("TO DO DELETED : {}",update);
    }

//delete multiple todos
    public void deletemultiple(int ids[])
    {
        String delete  = "delete from todos where id=?";
        //for each loop

        int[] ints = template.batchUpdate(delete, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {

                int id = ids[i];
                ps.setInt(1, id);
            }

            @Override
            public int getBatchSize() {
                return ids.length;
            }
        });

        for( int i : ints)
        {
            logger.info("Deleted todo : {}",i);
        }
    }

}
