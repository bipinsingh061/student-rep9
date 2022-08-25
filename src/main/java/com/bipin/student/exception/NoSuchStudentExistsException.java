package com.bipin.student.exception;

public class NoSuchStudentExistsException extends RuntimeException {

    private String message;

    public NoSuchStudentExistsException() {}

    public NoSuchStudentExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
