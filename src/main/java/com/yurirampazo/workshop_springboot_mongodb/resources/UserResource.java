package com.yurirampazo.workshop_springboot_mongodb.resources;

import com.yurirampazo.workshop_springboot_mongodb.domain.User;
import com.yurirampazo.workshop_springboot_mongodb.domain.dto.UserDto;
import com.yurirampazo.workshop_springboot_mongodb.services.UserService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

  @PostMapping
  public ResponseEntity<Void> insert(@RequestBody UserDto userDto){
    User user = userService.fromDto(userDto);
    user = userService.insert(user);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
          .path("/{id}").buildAndExpand(user.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
