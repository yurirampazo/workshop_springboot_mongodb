package com.yurirampazo.workshop_springboot_mongodb.repository;

import com.yurirampazo.workshop_springboot_mongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/** UserRepository with extend methods from MongoRepository.*/
@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
