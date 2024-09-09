package com.mapping.controller;

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

import com.mapping.entity.Student;
import com.mapping.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService ss;

	@GetMapping
	public ResponseEntity<List<Student>> getAll() {
		List<Student> list=ss.getAll();
		return ResponseEntity.ok(list);

	}

	@PostMapping("/insert")
	public ResponseEntity<Student> addStudent(Student student) {
		Student student1=ss.addStudent(student);
		return ResponseEntity.ok(student1);
		

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student student) {
		Student student1= ss.updateStudent(id, student);
		
		return ResponseEntity.ok(student1);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
		ss.deleteStudentById(id);
		return ResponseEntity.ok("Data is deleted");

	}

}
