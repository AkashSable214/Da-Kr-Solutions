package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapping.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Long> {

}
