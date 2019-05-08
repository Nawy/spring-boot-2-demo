package com.ie.springboot2serviceexample.repository;

import com.ie.springboot2serviceexample.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UserRepository extends MongoRepository<User, String>,
    QueryByExampleExecutor<User> {
}
