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

import com.spring.Entity.Passport;
import com.spring.service.PassportService;

@RestController
@RequestMapping("/passport")
public class PassportController {

	@Autowired
	PassportService ps;

	@GetMapping
	public ResponseEntity<List<Passport>> getAllPassport() {
		List<Passport> list = ps.getPassport();
		return ResponseEntity.ok(list);
	}

	@PostMapping("/insert")
	public ResponseEntity<Passport> addPerson(@RequestBody Passport passport) {
		Passport passport2= ps.addPassportDetail(passport);
		return ResponseEntity.ok(passport2);

	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Passport> updatePerson(@RequestBody Passport passport,Long id) {
		Passport passport2=ps.updatePassport(passport, id);
		return ResponseEntity.ok(passport2);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		ps.delete(id);
		return ResponseEntity.ok("Data is deleted");
	}

}
