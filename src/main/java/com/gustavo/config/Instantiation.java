package com.gustavo.config;

import com.gustavo.entities.User;
import com.gustavo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User maria = new User(null, "Maria", "maria@gmail.com");
        User bob = new User(null, "Bob", "bob@gmail.com");
        User gustavo = new User(null, "Gustavo", "gustavo@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, bob, gustavo));
    }
}