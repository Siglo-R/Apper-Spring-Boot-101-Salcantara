package com.gcash.theblogservice;


import com.gcash.theblogservice.ExceptionHandler.UserBloggerIdNotFoundException;
import com.gcash.theblogservice.model.Blog;
import com.gcash.theblogservice.payload.*;
import com.gcash.theblogservice.service.CreateBlogService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("blog")
public class BlogApi {


    private final CreateBlogService createBlogService;

    public BlogApi( CreateBlogService createBlogService){
        this.createBlogService = createBlogService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBlogResponse createBlog(@RequestBody @Valid CreateBlogRequest request) throws UserBloggerIdNotFoundException {

        Blog createdBlog = createBlogService.createBlog(request.getUserId(), request.getTitle(),request.getBody() );

        System.out.println(request);
        CreateBlogResponse response = new CreateBlogResponse();
        response.setUserId(createdBlog.getBlogger().getId());
        response.setBlogId(createdBlog.getBlogId());
        response.setBlogCreation(LocalDateTime.now());
        response.setBlogUpdate(createdBlog.getLastUpdate());
        return response;
    }

    @GetMapping("{blogId}")
    @ResponseStatus(HttpStatus.OK)
    public BlogDetails getBlog(@PathVariable String blogId) {
        Blog blog = createBlogService.getBlog(blogId);

        BlogDetails blogDetails = new BlogDetails();
        blogDetails.setBloggerId(blog.getBlogger().getId());
        blogDetails.setBody(blog.getBody());
        blogDetails.setTitle(blog.getTitle());
        blogDetails.setCreatedAt(blog.getCreatedAt());
        blogDetails.setLastUpdated(blog.getLastUpdate());

        return blogDetails;
    }

    @PutMapping("{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public UpdateBlogResponse updateBlog(@PathVariable String blogId, @RequestBody @Valid UpdateBlogRequest request)  {

        Blog updatedBlog = createBlogService.updateBlog(blogId, request.getTitle(),request.getBody());

        System.out.println(request);
        UpdateBlogResponse response = new UpdateBlogResponse();
        response.setUserId(updatedBlog.getBlogger().getId());
        response.setBlogId(updatedBlog.getBlogId());
        response.setBlogUpdate(updatedBlog.getLastUpdate());
        return response;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Blog> getAllBlogs(){
        return createBlogService.getAllBlogs();
    }



    @GetMapping("/blogger/{blogId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Blog> getAllBlogsByBlogger(@PathVariable String blogId){
        return createBlogService.getAllBlogsByBlogger(blogId);
    }



}