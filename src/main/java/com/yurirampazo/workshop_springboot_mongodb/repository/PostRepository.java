package com.yurirampazo.workshop_springboot_mongodb.repository;

import com.yurirampazo.workshop_springboot_mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
