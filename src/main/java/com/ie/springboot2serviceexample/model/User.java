package com.ie.springboot2serviceexample.model;

import java.time.LocalDateTime;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = User.COLLECTION_NAME)
public class User {

  public static final String COLLECTION_NAME = "users";

  @Id
  private String name;
  private String tabNumber;
  private Set<UserRole> roles;
  private Boolean isAdmin;
  private LocalDateTime createTime;

  public User() {
  }

  public User(String name, String tabNumber,
      Set<UserRole> roles, Boolean isAdmin, LocalDateTime createTime) {
    this.name = name;
    this.tabNumber = tabNumber;
    this.roles = roles;
    this.isAdmin = isAdmin;
    this.createTime = createTime;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTabNumber() {
    return tabNumber;
  }

  public void setTabNumber(String tabNumber) {
    this.tabNumber = tabNumber;
  }

  public Set<UserRole> getRoles() {
    return roles;
  }

  public void setRoles(Set<UserRole> roles) {
    this.roles = roles;
  }

  public Boolean isAdmin() {
    return isAdmin;
  }

  public void setAdmin(Boolean admin) {
    isAdmin = admin;
  }

  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }
}
