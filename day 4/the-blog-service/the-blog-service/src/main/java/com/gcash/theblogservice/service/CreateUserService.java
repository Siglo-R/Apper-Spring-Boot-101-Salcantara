package com.gcash.theblogservice.service;

import com.gcash.theblogservice.ExceptionHandler.EmailAlreadyRegisteredException;
import com.gcash.theblogservice.ExceptionHandler.UserBloggerIdNotFoundException;
import com.gcash.theblogservice.Repository.UserRepository;
import com.gcash.theblogservice.model.UserBlogger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreateUserService {
    private final UserRepository userRepository;
    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserBlogger createUser(String email, String name, String password) throws EmailAlreadyRegisteredException {
        if(userRepository.existsByEmail(email)==true){
            throw new EmailAlreadyRegisteredException("Email Already Registered");
        }
        UserBlogger userBlogger= new UserBlogger();
        userBlogger.setEmail(email);
        userBlogger.setName(name);
        userBlogger.setPassword(password);

        return userRepository.save(userBlogger);
    }
    public UserBlogger getUserBlogger(String id) throws UserBloggerIdNotFoundException {
        if(userRepository.existsById(id)==false){
            throw new UserBloggerIdNotFoundException("ID not found");
        }
        Optional<UserBlogger> userBloggerResult = userRepository.findById(id);

        return userBloggerResult.get();

    }
    public List<UserBlogger> getAllUserBlogger(){
        return (List<UserBlogger>) userRepository.findAll();
    }


}
