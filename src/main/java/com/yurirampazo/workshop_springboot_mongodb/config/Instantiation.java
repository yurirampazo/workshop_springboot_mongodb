package com.yurirampazo.workshop_springboot_mongodb.config;

import com.yurirampazo.workshop_springboot_mongodb.domain.Post;
import com.yurirampazo.workshop_springboot_mongodb.domain.User;
import com.yurirampazo.workshop_springboot_mongodb.domain.dto.AuthorDto;
import com.yurirampazo.workshop_springboot_mongodb.domain.dto.UserDto;
import com.yurirampazo.workshop_springboot_mongodb.repository.PostRepository;
import com.yurirampazo.workshop_springboot_mongodb.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


/** Configuration class for DataBase seeding and tests.*/
@Configuration
public class Instantiation implements CommandLineRunner {


  @Autowired
  UserRepository userRepository;

  @Autowired
  PostRepository postRepository;

  @Override
  public void run(String... args) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

    userRepository.deleteAll();
    postRepository.deleteAll();

    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Grey", "bob@gmail.com");
    userRepository.saveAll(Arrays.asList(maria, alex, bob));

    Post post1 = new Post(null, sdf.parse("21/03/2018"),
          "Partiu viagem!!!","Vou viajar para São Paulo. Abraços!", new AuthorDto(maria));
    Post post2 = new Post(null, sdf.parse("22/03/2018"),
          "Bom dia!","Acordei feliz hoje!", new AuthorDto(alex));
    postRepository.saveAll(Arrays.asList(post1,post2));

    maria.getPosts().addAll(Arrays.asList(post1,post2));
    userRepository.save(maria);
  }
}
