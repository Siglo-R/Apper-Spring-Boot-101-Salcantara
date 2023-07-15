package com.gcash.theblogservice.payload;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateBlogRequest {

    @NotBlank(message ="Title is Required")
    private String title;

    @NotBlank(message="body is required")
    private String body;


    @JsonProperty("blogger_id")
    @NotBlank(message = "blogger_id is required")
    private String userId;


}
