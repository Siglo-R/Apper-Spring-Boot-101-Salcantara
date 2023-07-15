package com.gcash.theblogservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="BLOGGER")
@Data
public class UserBlogger {

    @Id
    @Column(name = "BLOGGER_ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "COMPLETE_NAME")
    private String name;
    @Column(name = "PASSWORD")
    @JsonIgnore
    private String password;
    @Column(name= "EMAIL")
    private String email;
    @Column(name="CREATED_AT")
    @JsonProperty("date_registration")
    private LocalDateTime createdAt;
    @JsonIgnore
    @Column(name = "LAST_UPDATE")
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "blogger")
    @JsonIgnore
    private List<Blog> blogs;

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
