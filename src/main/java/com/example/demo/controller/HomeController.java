package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.demo.model.student;
import com.example.demo.service.studentservice;

@Controller

public class HomeController {
	
	
	@Autowired
	studentservice ss;
	
	
	@PostMapping("/saved")
	public ResponseEntity<String> third(@RequestBody student fm) {
		ss.getinf(fm);
		return ResponseEntity.status(HttpStatus.OK).body("Data is saved");
	}
	
	
	@GetMapping("/getstudents")
	 public ResponseEntity<List<student>> getAllStudents(){
		  List<student> students = ss.getall();
		  
		  if(!students.isEmpty()) {
	            
	            return ResponseEntity.status(HttpStatus.OK).body(students);
	        } else {
	           
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
		 
	 }
	

	 @DeleteMapping("/delstudents/{id}")
	    public ResponseEntity<String> delettudent(@PathVariable int id) {
	        
	        boolean deleted = ss.getdelete(id);

	        if (deleted) {
	            
	            return ResponseEntity.status(HttpStatus.OK).body("Student  " + id + " is deleted  successfully");
	        } else {
	            
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student ID " + id + " is not find");
	        }
	    }
	
	 @PutMapping("/updatestudent/{id}") // Add PutMapping for update
	    public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody student updatedStudent) {
	        ss.updatestudent(id, updatedStudent);
	        return ResponseEntity.status(HttpStatus.OK).body("Student with ID " + id + " is updated");
	    }
	
}
