package com.yurirampazo.workshop_springboot_mongodb.domain.dto;

import com.yurirampazo.workshop_springboot_mongodb.domain.User;
import java.io.Serializable;

/** Data Transfer Object for User Entity.*/
public class UserDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;
  private String name;
  private String email;

  public UserDto() {
  }

  /** Constructor with User as a parameter.*/
  public UserDto(User user) {
    id = user.getId();
    name = user.getEmail();
    email = user.getEmail();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail() {
    this.email = email;
  }
}
