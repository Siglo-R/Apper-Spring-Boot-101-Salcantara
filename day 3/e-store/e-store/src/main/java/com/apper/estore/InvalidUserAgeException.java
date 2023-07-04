package com.apper.estore;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.logging.log4j.message.Message;

import java.lang.Throwable;
public class InvalidUserAgeException extends Exception{
    public InvalidUserAgeException(String message) {
        super(message);
    }

}