package com.gcash.theblogservice.ExceptionHandler;

public class EmailAlreadyRegisteredException extends Exception{
    public EmailAlreadyRegisteredException(String message) {
        super(message);
    }

}
