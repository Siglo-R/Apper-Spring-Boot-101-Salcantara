package com.gcash.theblogservice;


import com.gcash.theblogservice.model.Blog;
import com.gcash.theblogservice.model.UserBlogger;
import com.gcash.theblogservice.payload.*;
import com.gcash.theblogservice.service.CreateBlogService;
import com.gcash.theblogservice.service.CreateUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("blogger")
public class UserApi {

    private final CreateUserService createUserService;

    private final CreateBlogService createBlogService;

    public UserApi(CreateUserService createUserService, CreateBlogService createBlogService){
        this.createUserService = createUserService;
        this.createBlogService = createBlogService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponse createUser(@RequestBody @Valid CreateUserRequest request) {

        UserBlogger createdUser = createUserService.createUser(request.getEmail(), request.getName(), request.getPassword());

        System.out.println(request);
        CreateUserResponse response = new CreateUserResponse();
        response.setId(createdUser.getId());
        response.setDateRegistration(LocalDateTime.now());
        return response;

    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDetails getUserBlogger(@PathVariable String id) {
        UserBlogger userBlogger = createUserService.getUserBlogger(id);

        UserDetails userDetails = new UserDetails();
        userDetails.setId(userBlogger.getId());
        userDetails.setName(userBlogger.getName());
        userDetails.setEmail(userBlogger.getEmail());
        userDetails.setDateRegistration(userBlogger.getCreatedAt());

        return userDetails;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserBlogger> getAllUserBlogger(){
        return createUserService.getAllUserBlogger();
    }







}