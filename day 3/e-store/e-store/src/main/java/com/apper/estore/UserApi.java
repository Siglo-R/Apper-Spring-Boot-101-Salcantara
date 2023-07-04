package com.apper.estore;

import jakarta.validation.Valid;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.lang.Throwable;

@RestController
@RequestMapping("user")
public class UserApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponse createUser(@RequestBody @Valid CreateUserRequest request) throws InvalidUserAgeException {
        LocalDate birthDate=LocalDate.parse(request.getBirthDate()),currentDate=LocalDate.now();

        if(Period.between(birthDate, currentDate).getYears()<15){
            throw new InvalidUserAgeException("Age must be greater than 15 years old");
        }

        return new CreateUserResponse("RANDOM_CODE_FOR_NOW");

    }





}