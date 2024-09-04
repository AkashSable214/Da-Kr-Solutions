package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.JenkinModel;
import com.spring.repo.JenkinsRepo;

@Service
public class JenkinService {
	@Autowired
	JenkinsRepo jr;
	
	public List<JenkinModel> getAll() {
		List<JenkinModel> list=jr.findAll();
		return list;
	}
	
	public JenkinModel addData(JenkinModel jm) {
		return jr.save(jm);
	}
	
	public JenkinModel updateData(JenkinModel jenkinModel ,long id) {
		JenkinModel jm=jr.findById(id).get();
		jm.setName(jenkinModel.getName());
		jm.setAddress(jenkinModel.getAddress());
		jm.setMobileNo(jenkinModel.getMobileNo());
		
		return jr.save(jm);
	}
	
	public void delete(long id) {
		jr.deleteById(id);
		
	}

}
