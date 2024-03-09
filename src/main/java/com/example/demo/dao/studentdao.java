package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.student;
import com.example.demo.repo.studentrepo;
import com.example.demo.service.studentservice;

@Service
public class studentdao implements studentservice {
	
	@Autowired
	studentrepo sr;

	@Override
	public void getinf(student s) {
		// TODO Auto-generated method stub
		sr.save(s);
		
	}

	@Override
	public List<student> getall() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public boolean getdelete(int id) {
		// TODO Auto-generated method stub
		sr.deleteById(id);
		return true;
		
	}

	@Override
	public void updatestudent(int id, student st) {
		// TODO Auto-generated method stub
		
		 student exstud = sr.findById(id).orElse(null);
		    
		    if (exstud != null) {
		    	exstud.setFirstname(st.getFirstname());
		    	exstud.setLastname(st.getLastname());
		    	exstud.setRollno(st.getRollno());
		    	exstud.setSubject(st.getSubject());
		    	exstud.setContact(st.getContact());
		        sr.save(exstud);
		    } else {
		        System.err.println("student " + id + " not found");
		    }
		
	}

}
