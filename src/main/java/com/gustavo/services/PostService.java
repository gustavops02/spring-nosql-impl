package com.gustavo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.entities.Post;
import com.gustavo.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		return postRepository.findById(id).get();
	}

}
