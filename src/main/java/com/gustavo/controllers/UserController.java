package com.gustavo.controllers;

import com.gustavo.dto.UserDTO;
import com.gustavo.entities.User;
import com.gustavo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {

        List<User> userList = userService.findAll();
        List<UserDTO> userDto = userList.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        UserDTO userDTO = new UserDTO(userService.findById(id));
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
        User userObj = userService.fromDTO(userDTO);
        userObj = userService.insert(userObj);

        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(userObj.getId()).
                toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO userDTO) {
        User userObj = userService.fromDTO(userDTO);
        userObj.setId(id);
        userObj = userService.update(userObj);


        return ResponseEntity.noContent().build();
    }
}
