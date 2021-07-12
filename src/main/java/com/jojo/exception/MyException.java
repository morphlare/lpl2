package com.jojo.exception;

/**
 * @author JOJO
 * @create 2021-06-23-13:38
 */
public class MyException extends Exception{
    private String message;

    public MyException(String message) {
        this.message = message;
    }

    public MyException() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
