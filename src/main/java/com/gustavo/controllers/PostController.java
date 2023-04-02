package com.gustavo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.controllers.util.URL;
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
	
	@GetMapping("/search")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decode(text);
		List<Post> list = postService.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/fullsearch")
	public ResponseEntity<List<Post>> findBetweenDates
(			@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "text", defaultValue = "") String minDate,
			@RequestParam(value = "text", defaultValue = "") String maxDate
			) {
		
		
		text = URL.decode(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = postService.findTextBetweenDates(text, min, max);
		
		return ResponseEntity.ok().body(list);
	}
}
