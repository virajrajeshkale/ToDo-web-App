package com.lcwd.ToDoManager.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionhandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionhandler.class);
    //create handler exceptions

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handlerNullpointerException(NullPointerException ex)
    {
            logger.info(" Null pointer exception :"+ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // handling resource not found exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Exceptionresponse> handlerResourceNotFoundException(ResourceNotFoundException ex)
    {
                logger.error("Error {}",ex.getMessage());
                Exceptionresponse exceptionresponse = new Exceptionresponse();
                exceptionresponse.setMessage(ex.getMessage());
                exceptionresponse.setStatus(HttpStatus.NOT_FOUND);
                exceptionresponse.setSuccess(false);
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionresponse);

    }
}
