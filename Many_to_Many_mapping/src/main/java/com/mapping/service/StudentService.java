package com.mapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.entity.Student;
import com.mapping.repository.StudentRepo;

@Service
public class StudentService {
	@Autowired
	StudentRepo sr;
	
	public List<Student> getAll() {
		return sr.findAll();
	}
	public Student addStudent(Student student) {
		return sr.save(student);
		
	}
	public Student updateStudent(Long id,Student student) {
		
		Student exStudent=sr.findById(id).get();
		if(exStudent!=null) {
			exStudent.setName(student.getName());
			exStudent.setEmail(student.getEmail());
			exStudent.setCourses(student.getCourses());
			
			return sr.save(exStudent);
		}else {
			return null;
		}
		
	}
	public void deleteStudentById(Long id) {
		
		sr.deleteById(id);
	}

}
