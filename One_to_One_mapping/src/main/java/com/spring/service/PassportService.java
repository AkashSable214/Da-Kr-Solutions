package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Entity.Passport;
import com.spring.repo.PassportRepo;

@Service
public class PassportService {
	@Autowired
	PassportRepo pr;
	
	public List<Passport> getPassport() {
		
		return pr.findAll();
	}
	
	public Passport addPassportDetail(Passport passport) {
		
		return pr.save(passport);
	}

	public Passport updatePassport(Passport passport,Long id) {
		Passport passport1=pr.findById(id).get();
		
		passport1.setPassportNumber(passport.getPassportNumber());
		
		return pr.save(passport1);
		
	}
	
	public void delete(Long id) {
		
		pr.deleteById(id);
	}
}
