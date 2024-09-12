package com.spring_Junit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_Junit.entity.Book;

public interface BookRepo extends JpaRepository<Book,Long> {

}
