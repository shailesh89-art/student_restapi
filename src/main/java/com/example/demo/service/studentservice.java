package com.example.demo.service;

import java.util.List;

import com.example.demo.model.student;



public interface studentservice {
	void getinf(student s );
	List<student> getall();

	boolean getdelete(int id);
	void updatestudent(int id, student st);

}
