package com.gcash.theblogservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="BLOGGER")
@Data
public class UserBlogger {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "COMPLETE_NAME")
    private String name;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name= "EMAIL")
    private String email;
    @Column(name="CREATED_AT")
    private LocalDateTime createdAt;

    @PrePersist//initialize before running
    public void setInitialTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
    }
}
