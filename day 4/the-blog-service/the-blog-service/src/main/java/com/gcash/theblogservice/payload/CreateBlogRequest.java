package com.gcash.theblogservice.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateBlogRequest {

    @NotBlank(message ="Title is Required")
    private String title;

    @NotBlank(message="body is required")
    private String body;


    @NotBlank(message = "userID is required")
    private String userId;


}
