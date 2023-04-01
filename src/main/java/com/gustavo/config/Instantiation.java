package com.gustavo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gustavo.entities.Post;
import com.gustavo.entities.User;
import com.gustavo.repositories.PostRepository;
import com.gustavo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {


    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
    	postRepository.deleteAll();
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	
        User maria = new User(null, "Maria", "maria@gmail.com");
        User bob = new User(null, "Bob", "bob@gmail.com");
        User gustavo = new User(null, "Gustavo", "gustavo@gmail.com");
        
        Post post1 = new Post(null, 
        		sdf.parse("21/03/2022"), 
        		"Curtindo as férias!", 
        		"Viajando por Porto Seguro",
        		maria);
        
        Post post2 = new Post(null, 
        		sdf.parse("29/04/20/2023"), 
        		"Amo o meu cachorro!", 
        		"muito lindo!!",
        		gustavo);
        
        userRepository.saveAll(Arrays.asList(maria, bob, gustavo));
        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}
