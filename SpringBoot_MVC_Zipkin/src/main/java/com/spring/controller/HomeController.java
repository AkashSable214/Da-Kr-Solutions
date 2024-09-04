package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.service.StudentService;

@Controller
public class HomeController {

    @Autowired
    private StudentService ss;

    @GetMapping
    public String index() {
        return "index";
    }
//  index page after submit button
 	@PostMapping("/student1")
 	public ModelAndView handleAction(@RequestParam("student1") String action) {
 		switch (action) {
 		
 		case "add":
 			return new ModelAndView("add");
 		case "update":
 			return new ModelAndView("update");
 		case "delete":

 			return new ModelAndView("delete");
 		case "all":

 			return new ModelAndView("table");
 		default:
 			return new ModelAndView("error");
 		}
     
 	}
    
    
}