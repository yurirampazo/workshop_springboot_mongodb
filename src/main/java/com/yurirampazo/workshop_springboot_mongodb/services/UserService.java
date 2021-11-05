package com.yurirampazo.workshop_springboot_mongodb.services;

import com.yurirampazo.workshop_springboot_mongodb.domain.User;
import com.yurirampazo.workshop_springboot_mongodb.repository.UserRepository;
import java.util.List;
import java.util.Optional;

import com.yurirampazo.workshop_springboot_mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service witch comunicates with UserRepository.
 */
@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById (String id) {
    Optional<User> user = userRepository.findById(id);
    return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
  }
}
