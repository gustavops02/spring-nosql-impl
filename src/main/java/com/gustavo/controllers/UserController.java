package com.gustavo.controllers;

import com.gustavo.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User(1, "Maria", "maria@gmail.com");
        User alex = new User(1, "Alex", "alex@gmail.com");

        return ResponseEntity.ok().body(new ArrayList<>(Arrays.asList(maria, alex)));
    }
}
