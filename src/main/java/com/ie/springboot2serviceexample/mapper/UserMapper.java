package com.ie.springboot2serviceexample.mapper;

import com.ie.springboot2serviceexample.model.CreateUserDto;
import com.ie.springboot2serviceexample.model.User;
import com.ie.springboot2serviceexample.model.UserDto;

public class UserMapper {

  private UserMapper() {
  }

  public static UserDto toDto(User user) {
    return new UserDto(
        user.getName(),
        user.getTabNumber(),
        user.getRoles(),
        user.isAdmin(),
        user.getCreateTime()
    );
  }

  public static User fromDto(UserDto user) {
    return new User(
        user.getName(),
        user.getTabNumber(),
        user.getRoles(),
        user.isAdmin(),
        user.getCreateTime()
    );
  }

  public static User fromDto(CreateUserDto user) {
    return new User(
        user.getName(),
        user.getTabNumber(),
        user.getRoles(),
        user.isAdmin(),
        null
    );
  }
}
