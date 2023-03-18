package com.gustavo.services;

import com.gustavo.entities.User;
import com.gustavo.repositories.UserRepository;
import com.gustavo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById (String id){
        User user = userRepository
                .findById(id).
                orElseThrow(() -> new ObjectNotFoundException("Object not found."));
        return user;

    }
}
