package com.yurirampazo.workshop_springboot_mongodb.resources;

import com.yurirampazo.workshop_springboot_mongodb.domain.User;
import com.yurirampazo.workshop_springboot_mongodb.domain.dto.UserDto;
import com.yurirampazo.workshop_springboot_mongodb.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for communication with client side.
 */
@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
  private UserService userService;

  @GetMapping
  public final ResponseEntity<List<UserDto>> findALl() {
    List<User> list = userService.findAll();
    List<UserDto> listDto = list.stream()
          .map(UserDto::new).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<UserDto> findById(@PathVariable String id) {
    User user = userService.findById(id);
    return ResponseEntity.ok().body(new UserDto(user));
  }
}
