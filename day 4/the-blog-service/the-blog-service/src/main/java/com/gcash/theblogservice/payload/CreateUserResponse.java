package com.gcash.theblogservice.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class CreateUserResponse {
    private String id;

    @JsonProperty("date_registration")
    private LocalDateTime dateRegistration;
}
