package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Entity.Person;
import com.spring.service.PersonService;

@RestController
@RequestMapping("/person")
public class Personcontroller {

	@Autowired
	PersonService ps;
	
	@GetMapping
	public ResponseEntity<List<Person>> getAllPerson() {
		List<Person> list=ps.getAllPersons();
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
		
		Person person=ps.getPersonById(id);
		
		return ResponseEntity.ok(person);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Person> addPersonInfo(@RequestBody Person person) {
		
		Person person1=ps.addPerson(person);
		return ResponseEntity.ok(person1);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Person> updatePersonInfo(@RequestBody Person person,@PathVariable Long id) {
		Person person1=ps.updatePerson(id, person);
		
		return ResponseEntity.ok(person1);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePersonById(@PathVariable Long id) {
		ps.deleteById(id);
		return ResponseEntity.ok("Data is Deleted");
	}
}
