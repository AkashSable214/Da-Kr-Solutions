package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

}
