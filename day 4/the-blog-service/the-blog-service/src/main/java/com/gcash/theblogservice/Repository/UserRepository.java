package com.gcash.theblogservice.Repository;

import com.gcash.theblogservice.model.UserBlogger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserBlogger, String> {

    Boolean existsByEmail(String email);
    boolean existsById(String id);

}
