package com.yurirampazo.workshop_springboot_mongodb.services;

import com.yurirampazo.workshop_springboot_mongodb.domain.User;
import com.yurirampazo.workshop_springboot_mongodb.domain.dto.UserDto;
import com.yurirampazo.workshop_springboot_mongodb.repository.UserRepository;
import com.yurirampazo.workshop_springboot_mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  public User insert(User user) {
    return userRepository.insert(user);
  }

  public void delete(String id) {
    findById(id);
    userRepository.deleteById(id);
  }

  public User update (User user) {
    User newUser = findById(user.getId());
    updateData(newUser, user);
    return userRepository.save(newUser);
  }

  private void updateData(User newUser, User user) {
    newUser.setId(user.getId());
    newUser.setEmail(user.getEmail());
    newUser.setName(user.getName());
  }

  public User fromDto(UserDto userDto) {
    return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
  }
}
