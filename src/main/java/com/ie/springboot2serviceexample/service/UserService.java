package com.ie.springboot2serviceexample.service;

import com.ie.springboot2serviceexample.model.User;
import com.ie.springboot2serviceexample.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User create(User user) {
    user.setCreateTime(LocalDateTime.now());
    return userRepository.save(user);
  }

  public List<User> find(User user) {
    ExampleMatcher matcher = ExampleMatcher.matching()
        .withIncludeNullValues()
        .withIgnoreCase();
    return userRepository.findAll(Example.of(user, matcher));
  }

  public Optional<User> get(String name) {
    return userRepository.findById(name);
  }

  public void delete(String name) {
    userRepository.deleteById(namegit);
  }
}
