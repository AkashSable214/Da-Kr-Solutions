package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Author;

public interface AuthorRepo extends JpaRepository<Author, Long> {

}
