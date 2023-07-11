package com.gcash.theblogservice;


import com.gcash.theblogservice.model.UserBlogger;
import com.gcash.theblogservice.payload.CreateUserRequest;
import com.gcash.theblogservice.payload.CreateUserResponse;
import com.gcash.theblogservice.payload.UserDetails;
import com.gcash.theblogservice.service.UserService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@RestController
@RequestMapping("blogger")
public class UserApi {

    private final UserService userService;

    public UserApi(UserService userService){
        this.userService=userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponse createUser(@RequestBody @Valid CreateUserRequest request) {

        UserBlogger createdUser = userService.createUser(request.getEmail(), request.getName(), request.getPassword());

        System.out.println(request);
        CreateUserResponse response = new CreateUserResponse();
        response.setId("dummy_id");
        response.setDateRegistration(LocalDateTime.now());
        return response;

    }

    @GetMapping("{id}")
    public UserDetails getUserBlogger(@PathVariable String id) {
        UserBlogger userBlogger = userService.getUserBlogger(id);

        UserDetails userDetails = new UserDetails();
        userDetails.setId(userBlogger.getId());
        userDetails.setName(userBlogger.getName());
        userDetails.setEmail(userBlogger.getEmail());
        userDetails.setDateRegistration(userBlogger.getCreatedAt());

        return userDetails;
    }





}