package com.deliverybusiness.exception;

public class WrongIdException extends RuntimeException{
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public WrongIdException(String message) {
        super();
        this.message = message;
    }
}
