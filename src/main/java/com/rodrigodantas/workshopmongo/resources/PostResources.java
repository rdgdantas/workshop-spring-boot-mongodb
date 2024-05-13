package com.rodrigodantas.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigodantas.workshopmongo.domain.Post;
import com.rodrigodantas.workshopmongo.resources.util.URL;
import com.rodrigodantas.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResources {
	
	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByIdTitle(@RequestParam(value="text",defaultValue = "") String text){
		text = URL.decodeParam(text);
		List<Post> list = service.fingByTitle(text);
		
		return ResponseEntity.ok().body(list);
	}
	
}