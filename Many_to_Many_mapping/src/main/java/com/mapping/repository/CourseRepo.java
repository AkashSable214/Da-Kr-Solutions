package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapping.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {

}
