package com.gustavo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.entities.Post;
import com.gustavo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		
		Post postObj = postService.findById(id);
		
		return ResponseEntity.ok().body(postObj);
	}
}
