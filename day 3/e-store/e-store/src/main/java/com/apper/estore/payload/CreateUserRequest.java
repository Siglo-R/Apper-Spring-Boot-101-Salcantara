package com.apper.estore.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class CreateUserRequest {
        @NotBlank(message ="E-mail is Required")
        @Email(message = "Invalid email please re-enter")
        private String email;

        @NotBlank(message="password is required")
        @Size(min=8, message = "password must be at least 8 characters")
        private String password;

        @JsonProperty("first_name")
        @NotBlank(message= "First name is Required")
        private String firstName;

        @JsonProperty("middle_name")
        private String middleName;

        @JsonProperty("last_name")
        @NotBlank(message= "Last name is Required")
        private String lastName;

        @JsonProperty("birth_date")
        @NotBlank(message= "Birth date is required")
        @Pattern(regexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}",message = "please input correct birthday format ")
        private String birthDate;
    }

