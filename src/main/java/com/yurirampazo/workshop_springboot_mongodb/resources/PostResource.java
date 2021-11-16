package com.yurirampazo.workshop_springboot_mongodb.resources;

import com.yurirampazo.workshop_springboot_mongodb.domain.Post;
import com.yurirampazo.workshop_springboot_mongodb.resources.util.Url;
import com.yurirampazo.workshop_springboot_mongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Controller for communication with client side.
 */
@RestController
@RequestMapping(value = "/posts")
public class PostResource {

  @Autowired
  private PostService service;

  @GetMapping
  public ResponseEntity<List<Post>> findAll() {
    List<Post> posts = service.findAll();
    return ResponseEntity.ok().body(posts);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Post> findById(@PathVariable String id) {
    Post post = service.findById(id);
    return ResponseEntity.ok().body(post);
  }

  @GetMapping(value = "/titlesearch")
  public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
    text = Url.decodeParameters(text);
    List<Post> posts = service.findByTitle(text);
    return ResponseEntity.ok().body(posts);
  }

  @GetMapping(value = "/fullsearch")
  public ResponseEntity<List<Post>> fullSearch(
        @RequestParam(value = "text", defaultValue = "") String text,
        @RequestParam(value = "minDate", defaultValue = "") String minDate,
        @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
    text = Url.decodeParameters(text);
    Date min = Url.comvertDate(minDate, new Date(0L));
    Date max = Url.comvertDate(maxDate, new Date());
    List<Post> posts = service.fullSearch(text, min, max);
    return ResponseEntity.ok().body(posts);
  }
}
