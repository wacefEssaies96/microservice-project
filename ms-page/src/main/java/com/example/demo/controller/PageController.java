package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Page;
import com.example.demo.services.interfaces.PageService;

@RestController
@RequestMapping(value="/api/Pages")
public class PageController {

	@Autowired
	private PageService PageSer;

	@GetMapping("/all")
	public List<Page> displayAllPages() {
		return PageSer.afficherPages();
	}

	@GetMapping(value="/Page/{Id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page PageById(@PathVariable(value="Id") int Id) {
		return PageSer.chercherPage(Id);
	}
	
	@PostMapping
	public ResponseEntity<Page> createPage(@RequestBody Page p){
		return new ResponseEntity<>(PageSer.ajouterPage(p), HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page> updatePage(@PathVariable(value="id") int id ,@RequestBody Page p){
		return new ResponseEntity<>(PageSer.modifierPage(id, p), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deletePage(@PathVariable(value="id") int id){
		return new ResponseEntity<>(PageSer.supprimerPage(id), HttpStatus.OK);
	}
}
