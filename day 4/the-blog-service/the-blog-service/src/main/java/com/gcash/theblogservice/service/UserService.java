package com.gcash.theblogservice.service;

import com.gcash.theblogservice.Repository.UserRepository;
import com.gcash.theblogservice.model.UserBlogger;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserBlogger createUser(String email, String name, String password){
        UserBlogger userBlogger= new UserBlogger();
        userBlogger.setEmail(email);
        userBlogger.setName(name);
        userBlogger.setPassword(password);

        return userRepository.save(userBlogger);
    }
    public UserBlogger getUserBlogger(String id){
        Optional<UserBlogger> userBloggerResult = userRepository.findById(id);

        return userBloggerResult.get();

    }
}
