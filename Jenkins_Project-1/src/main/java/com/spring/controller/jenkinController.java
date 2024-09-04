package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.JenkinModel;
import com.spring.service.JenkinService;

@RestController
@RequestMapping("/api")
public class jenkinController {

	@Autowired
	JenkinService js;

	@GetMapping("/all")
	public List<JenkinModel> getAll() {
		List<JenkinModel> list = js.getAll();
		return list;
	}
	
	@PostMapping("/add")
		public JenkinModel addData(@RequestBody JenkinModel jenkinModel) {
		JenkinModel jm=	js.addData(jenkinModel);
		return jm;
		}
	
	@PutMapping("/update/{id}")
	public JenkinModel updateData(@PathVariable long id, @RequestBody JenkinModel jenkinModel) {
		return js.updateData(jenkinModel, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteData(@PathVariable long id) {
		js.delete(id);
		return "Data Deleted";
	}
	
}
