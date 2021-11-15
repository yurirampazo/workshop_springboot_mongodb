package com.yurirampazo.workshop_springboot_mongodb.repository;

import com.yurirampazo.workshop_springboot_mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

  @Query("{ 'title': { $regex: ?0/pattern/, $options: 'i' } }")
  List<Post> searchTitle(String text);

  //Containing = Case Sensitive.
  //ContainingIgnoreCase = Better for great search.
  List<Post> findByTitleContainingIgnoreCase(String text);
}
