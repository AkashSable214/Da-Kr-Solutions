package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Entity.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {

}
