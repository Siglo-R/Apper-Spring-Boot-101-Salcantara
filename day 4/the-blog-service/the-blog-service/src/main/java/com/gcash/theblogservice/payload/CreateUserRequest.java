package com.gcash.theblogservice.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class CreateUserRequest {
    @NotBlank(message ="E-mail is Required")
    @Email(message = "Invalid email please re-enter")
    private String email;

    @NotBlank(message="password is required")
    @Size(min=5, message = "password must be at least 5 characters")
    private String password;

    @JsonProperty("name")
    @NotBlank(message= "name is Required")
    private String Name;



}