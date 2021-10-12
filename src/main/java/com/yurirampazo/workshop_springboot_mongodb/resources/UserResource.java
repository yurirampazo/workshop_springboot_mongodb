package com.yurirampazo.workshop_springboot_mongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.yurirampazo.workshop_springboot_mongodb.domain.User;

import com.yurirampazo.workshop_springboot_mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findALl(){
        List<User> list = userService.findALl();
        return ResponseEntity.ok().body(list);
    }
}
