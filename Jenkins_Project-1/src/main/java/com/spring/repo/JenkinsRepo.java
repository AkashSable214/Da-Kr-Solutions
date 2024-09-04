package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.JenkinModel;

@Repository
public interface JenkinsRepo extends JpaRepository<JenkinModel, Long>{

}
