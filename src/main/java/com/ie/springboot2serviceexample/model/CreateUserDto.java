package com.ie.springboot2serviceexample.model;

import java.util.Set;

public class CreateUserDto {

  private String name;
  private String tabNumber;
  private Set<UserRole> roles;
  private boolean isAdmin;

  public CreateUserDto() {
  }

  public CreateUserDto(String name, String tabNumber,
      Set<UserRole> roles, Boolean isAdmin) {
    this.name = name;
    this.tabNumber = tabNumber;
    this.roles = roles;
    this.isAdmin = isAdmin;
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

  public boolean isAdmin() {
    return isAdmin;
  }

  public void setAdmin(boolean admin) {
    isAdmin = admin;
  }
}
