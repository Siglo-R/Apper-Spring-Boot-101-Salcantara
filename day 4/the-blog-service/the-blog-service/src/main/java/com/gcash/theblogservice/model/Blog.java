package com.gcash.theblogservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="BLOG")
@Data
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="BLOG_ID")
    private String blogId;

    @ManyToOne
    @JoinColumn(name="BLOGGER_ID")
    @JsonIgnore
    private UserBlogger blogger;

    @Column(name="CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name="TITLE")
    private String title;

    @Column(name="Body")
    private String body;

    @Column(name = "LAST_UPDATE")
    private LocalDateTime lastUpdate;


    @PrePersist//initialize before running
    public void setInitialTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        lastUpdate= now;
    }
    @PreUpdate
    public void setLastUpdate() {
        lastUpdate = LocalDateTime.now();
    }
}
