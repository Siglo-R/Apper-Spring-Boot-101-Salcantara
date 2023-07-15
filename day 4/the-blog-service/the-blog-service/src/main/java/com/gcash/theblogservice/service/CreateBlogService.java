package com.gcash.theblogservice.service;

import com.gcash.theblogservice.ExceptionHandler.UserBloggerIdNotFoundException;
import com.gcash.theblogservice.Repository.BlogRepository;
import com.gcash.theblogservice.model.Blog;
import com.gcash.theblogservice.payload.GetBloggerDetails;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CreateBlogService {

    private final CreateUserService createUserService;

    private final BlogRepository blogRepository;

    public CreateBlogService(CreateUserService createUserService, BlogRepository blogRepository) {
        this.createUserService = createUserService;
        this.blogRepository=blogRepository;

    }


    public Blog createBlog( String userId, String title, String body) throws UserBloggerIdNotFoundException {
        Blog blog= new Blog();
        blog.setBlogger(createUserService.getUserBlogger(userId));
        blog.setTitle(title);
        blog.setBody(body);

        return blogRepository.save(blog);
    }

    public Blog getBlog(String id){
        Optional<Blog> BlogResult = blogRepository.findById(id);

        return BlogResult.get();

    }

    public Blog updateBlog( String blogId, String title, String body){
        Blog blog= getBlog(blogId);
        blog.setTitle(title);
        blog.setBody(body);

        return blogRepository.save(blog);
    }

    public List<Blog> getAllBlogs(){
        return (List<Blog>) blogRepository.findAll();
    }
    public List<GetBloggerDetails> getAllBlogsByBlogger(String bloggerId){
        List<Blog> blogs = blogRepository.findAllByBlogger_Id(bloggerId);
        List<GetBloggerDetails> blogResponses = new ArrayList<>();
        for (Blog blog : blogs) {
            GetBloggerDetails blogResponse = new GetBloggerDetails();
            BeanUtils.copyProperties(blog, blogResponse);
            blogResponses.add(blogResponse);
        }
        return blogResponses;
    }




}
