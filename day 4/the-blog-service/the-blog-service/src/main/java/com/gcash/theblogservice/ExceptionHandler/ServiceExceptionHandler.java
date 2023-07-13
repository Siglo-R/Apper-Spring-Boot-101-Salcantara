package com.gcash.theblogservice.ExceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice
public class ServiceExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ServiceError handleInvalidField(MethodArgumentNotValidException ex){
        /*
        Exception handler para ioutput yung message
        getbinding lahat ng error messages result
        getAllErrors lahat ng error response
        .stream lambda function to get default messages
        */
        return ex.getBindingResult().getAllErrors().stream()
                .findFirst()
                .map(objectError -> new ServiceError(objectError.getDefaultMessage()))
                .orElse(new ServiceError("Unknown invalid argument encountered"));
    }

    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ServiceError handleEmailAlreadyRegisteredException(EmailAlreadyRegisteredException ex){
        return new  ServiceError(ex.getMessage());
    }

    @ExceptionHandler(UserBloggerIdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ServiceError handleUserBloggerIdNotFoundException(UserBloggerIdNotFoundException ex){
        return new  ServiceError(ex.getMessage());
    }



}
