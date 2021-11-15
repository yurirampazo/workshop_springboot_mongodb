package com.yurirampazo.workshop_springboot_mongodb.services;

import com.yurirampazo.workshop_springboot_mongodb.domain.Post;
import com.yurirampazo.workshop_springboot_mongodb.repository.PostRepository;
import com.yurirampazo.workshop_springboot_mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * Service witch comunicates with PostRepository.
 */
@Service
public class PostService {

  @Autowired
  private PostRepository repository;

  public List<Post> findAll () {
    return repository.findAll();
  }

  public Post findById(String id) {
    Optional<Post> post = repository.findById(id);
    return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado."));
  }

}
