package com.spring.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.spring.entity.Student;
import com.spring.service.StudentService;
import com.spring.service.StudentServiceImpl;

@Controller
public class StudentController {
 
     @Autowired
     StudentServiceImpl ss;
     
  // index page after submit button
     @PostMapping("/student")
     public ModelAndView handleAction(@RequestParam("student") String action) {
    	 ModelAndView modelAndView = new ModelAndView();
    	    
    	    switch (action) {
    	        case "add":
    	            modelAndView.setViewName("add");
    	            break;
    	        case "update":
    	            modelAndView.setViewName("update");
    	            break;
    	        case "delete":
    	            modelAndView.setViewName("delete");
    	            break;
    	        case "all":
    	            List<Student> students = ss.getAllStudents();
    	            modelAndView.addObject("collegeStudent", students);
    	            modelAndView.setViewName("table");
    	            break;
    	        default:
    	            modelAndView.setViewName("error");
    	            break;
    	    }
    	    
    	    return modelAndView;
     }
     

//   all data from database to table.jsp page
     @GetMapping("/students")
     public String getAllStudents(Model model) {
         List<Student> students = ss.getAllStudents();
         model.addAttribute("collegeStudent", students);
         return "table";
     }


//   check the studentId from the data base
     @PostMapping("/student/updateId")
     public String getStudentById(@RequestParam("studentId") Long studentId, Model model) {
         Student student = ss.getStudentById(studentId);
         model.addAttribute("student", student);
         return "update"; // Return the JSP view with student data
     }
//     update the the existing data
     @PostMapping("/student/update")
     public String updateStudent(@ModelAttribute("student") Student student, Model model) {
         Student existingStudent = ss.getStudentById(student.getStudentId());
         if (existingStudent != null) {
             existingStudent.setStudentName(student.getStudentName());
             existingStudent.setEmail(student.getEmail());
             existingStudent.setContactNo(student.getContactNo());
             existingStudent.setAddress(student.getAddress());
             ss.saveStudent(existingStudent);
         }

         List<Student> students = ss.getAllStudents();
         model.addAttribute("collegeStudent", students);

         return "table";
     }
//   show the updated data
   @GetMapping("/student/update")
   public String showUpdateStudentForm(Model model) {
       model.addAttribute("studentId", "");
       return "update"; 
   }

     
//   delete the student information from the database
     @PostMapping("/student/delete")
     public String deleteStudent(@RequestParam("studentId") Long studentId) {
         ss.deleteStudent(studentId);
         return "redirect:/students"; // Redirect to the list of students after deleting
     }
     
//   after delete the student information from the database remaining data is display
    @GetMapping("/student/delete")
    public String showDeleteStudentForm(Model model) {
        model.addAttribute("collegeStudent", new Student());
        return "delete"; 
    }
     

     
//     add student into database
     @PostMapping("/student/add")
     public String addStudent(@ModelAttribute("student") Student student) {
         ss.saveStudent(student);
         return "redirect:/students"; // Redirect to the list of students after adding
     }
  // after add student data is all data is display
     @GetMapping("/student/add")
     public String showAddStudentForm(Model model) {
         model.addAttribute("student", new Student());
         return "add"; // Return the correct JSP view for adding student
     }
     
}
