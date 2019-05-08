package com.ie.springboot2serviceexample.controller;

import com.ie.springboot2serviceexample.mapper.UserMapper;
import com.ie.springboot2serviceexample.model.CreateUserDto;
import com.ie.springboot2serviceexample.model.User;
import com.ie.springboot2serviceexample.model.UserDto;
import com.ie.springboot2serviceexample.model.exception.NotFoundException;
import com.ie.springboot2serviceexample.service.UserService;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/users")
  public UserDto create(@RequestBody CreateUserDto userDto) {
    return UserMapper.toDto(
        userService.create(UserMapper.fromDto(userDto))
    );
  }

  @GetMapping("/users")
  public List<UserDto> find(
      @RequestParam(required = false)String name,
      @RequestParam(required = false) Boolean isAdmin,
      @RequestParam(required = false) String tabNumber
  ) {
    User userExample = new User(
        name,
        tabNumber,
        null,
        isAdmin,
        null
    );
    return userService.find(userExample)
        .stream()
        .map(UserMapper::toDto)
        .collect(Collectors.toList());
  }

  @GetMapping("/users/{name}")
  public UserDto getByUserName(@PathVariable("name") String name) {
    return UserMapper.toDto(
        userService.get(name)
            .orElseThrow(() -> new NotFoundException("User not found!"))
    );
  }

  @DeleteMapping("/users/{name}")
  public void delete(@PathVariable("name") String name) {
    userService.delete(name);
  }
}
