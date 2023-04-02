package com.gustavo.services;

import java.util.Date;
import java.util.List;

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
	
	public List<Post> findByTitle(String txt) {
		List<Post> posts = postRepository.findByTitleContainingIgnoreCase(txt);
		return posts;
	}
	
	public List<Post> findTextBetweenDates(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24*60*60*1000);
		return postRepository.findTextBetweenDates(text, minDate, maxDate);
		
	}

}
