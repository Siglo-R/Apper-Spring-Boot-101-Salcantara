package com.gcash.theblogservice.Repository;

import com.gcash.theblogservice.model.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BlogRepository extends CrudRepository<Blog, String> {
    List<Blog> findAllByBlogger_Id( String Blogger_Id );



}
