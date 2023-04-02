package com.gustavo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gustavo.dto.AuthorDTO;
import com.gustavo.dto.CommentDTO;
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
        userRepository.saveAll(Arrays.asList(maria, bob, gustavo));
        
        Post post1 = new Post(null, 
        		sdf.parse("21/03/2022"), 
        		"Curtindo as férias!", 
        		"Viajando por Porto Seguro",
        		new AuthorDTO(maria));
        
        Post post2 = new Post(null, 
        		sdf.parse("29/04/20/2023"), 
        		"Amo o meu cachorro!", 
        		"muito lindo!!",
        		new AuthorDTO(gustavo));
        
        CommentDTO c1 = new CommentDTO("Lindas fotos!", sdf.parse("04/04/2023"), new AuthorDTO(gustavo));
        CommentDTO c2 = new CommentDTO("Seu cachorro é muito fofo!", sdf.parse("04/04/2023"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Lindas fotos!", sdf.parse("04/04/2023"), new AuthorDTO(maria));

        post1.getComments().add(c1);
        post2.getComments().addAll(Arrays.asList(c2,c3));
       
        postRepository.saveAll(Arrays.asList(post1,post2));
        maria.getPosts().add(post1);
        gustavo.getPosts().add(post2);
        userRepository.saveAll(Arrays.asList(maria, gustavo));
        
        
    }
}
