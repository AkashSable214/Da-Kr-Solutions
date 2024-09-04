package com.spring.service;



import java.util.List;

import com.spring.entity.Student;

public interface StudentService {
 List<Student> getAllStudents();
 Student getStudentById(Long studentId);
 void saveStudent(Student student);
 void deleteStudent(Long studentId);
}
