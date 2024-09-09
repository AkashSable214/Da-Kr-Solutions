package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Entity.Passport;

public interface PassportRepo extends JpaRepository<Passport, Long> {

}
