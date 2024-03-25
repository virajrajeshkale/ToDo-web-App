package com.lcwd.ToDoManager.Exception;

import org.springframework.http.HttpStatus;

public class Exceptionresponse {
    private  String message;
    private Boolean success;
    private HttpStatus status;

    public Exceptionresponse(String message, Boolean success, HttpStatus status) {
        this.message = message;
        this.success = success;
        this.status = status;
    }

    public Exceptionresponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
