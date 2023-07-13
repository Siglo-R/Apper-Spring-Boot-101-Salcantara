package com.gcash.theblogservice.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateBlogRequest {

    @NotBlank(message ="Title is Required")
    private String title;

    @NotBlank(message="body is required")
    private String body;



}
