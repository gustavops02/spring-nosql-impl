package com.gustavo.services;

import com.gustavo.dto.UserDTO;
import com.gustavo.entities.User;
import com.gustavo.repositories.UserRepository;
import com.gustavo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



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

    public User insert(User obj) {
        return userRepository.save(obj);
    }

    public User fromDTO (UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

}
