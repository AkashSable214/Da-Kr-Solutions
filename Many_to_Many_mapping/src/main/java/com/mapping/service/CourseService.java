package com.mapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.entity.Course;
import com.mapping.repository.CourseRepo;

@Service
public class CourseService {

	@Autowired
	CourseRepo cr;

	public List<Course> getAll() {
		List<Course> list = cr.findAll();
		return list;
	}

	public Course addCourse(Course course) {

		return cr.save(course);
	}

	public Course updateCourse(Course course, Long id) {
		Course course1 = cr.findById(id).get();

		if (course1 != null) {
			course1.setName(course.getName());
			course1.setDiscription(course.getDiscription());
			course1.setStudents(course.getStudents());

			return cr.save(course1);
		} else {
			return null;
		}
	}

	public void deleteCourseById(Long id) {
		cr.deleteById(id);
	}

}
