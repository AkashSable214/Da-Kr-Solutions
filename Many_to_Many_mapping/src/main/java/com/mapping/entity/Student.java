package com.mapping.entity;


import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	
	@ManyToMany
//	@JoinColumn(name="student_course",
//	joinColumns=@JoinColumn(name="student_id"),
//	inversJoinColumns=@joinColumn(name="course_id"))
	 @JoinTable(
		        name = "student_course",
		        joinColumns = @JoinColumn(name = "student_id"),
		        inverseJoinColumns = @JoinColumn(name = "course_id")
		    )
	private Set<Course> courses;

}
