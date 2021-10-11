package com.yurirampazo.workshop_springboot_mongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.yurirampazo.workshop_springboot_mongodb.domain.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findALl(){
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User alex = new User("1", "Alex Green", "alex@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
    }
}
