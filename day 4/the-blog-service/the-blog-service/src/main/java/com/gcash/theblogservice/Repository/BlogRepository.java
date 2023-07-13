package com.gcash.theblogservice.Repository;

import com.gcash.theblogservice.model.Blog;
import com.gcash.theblogservice.model.UserBlogger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends CrudRepository<Blog, String> {
    List<Blog> findAllByBlogger_Id( String Blogger_Id );



}
