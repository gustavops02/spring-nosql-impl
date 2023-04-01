package com.gustavo.services;

import com.gustavo.dto.UserDTO;
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

    public User insert(User obj) {
        return userRepository.save(obj);
    }

    public void delete (String id) {
        findById(id);
        userRepository.deleteById(id);
    }
    
    public User update(User user) {
    	User newObj = userRepository.findById(user.getId()).get();
    	updateData(newObj, user);
    	
    	userRepository.save(newObj);
    	return newObj;
    	
    }

    private void updateData(User newObj, User user) {
		newObj.setName(user.getName());
		newObj.setEmail(user.getEmail());

	}

	public User fromDTO (UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

}
