package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{

	Student findByStudentId(Long studentId);
	
	

}
