package com.apper;

import lombok.Data; // so as not to implement getters and setters na

import java.time.LocalDateTime;

//different ang account sa create account (idea of a repository)
@Data
public class Account {
    private String id;
    private Double balance;

    private String firstName;
    private String lastName;
    private String username;
    private String clearPassword;
    private String verificationCode;

    private LocalDateTime creationDate;
    private LocalDateTime lastUpdated;

}
