package com.springboot.student.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.student.main.model.StudentModel;
import com.springboot.student.main.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository sr;
	
	
	public ResponseEntity<?> getStudents() {
		try{
			List<StudentModel> sm=  sr.findAll();
			return new ResponseEntity<>(sm,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("No data found",HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Object> getById(int id) {
		
		try {
		StudentModel sm = sr.findById(id).get();
		if(sm.getId()>0) {
		return new ResponseEntity<>(sm,HttpStatus.OK);}
		else {
			return new ResponseEntity<>("No data found...",HttpStatus.NOT_FOUND);
		}
		}catch(Exception e) {
			return new ResponseEntity<Object>("No data found for id ",HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Object> getByName(String name) {
			
			try {
			StudentModel sm = sr.findByName(name);
			if(sm.getId()>0 && sm.getId()<=getMaxId()) {
			return new ResponseEntity<>(sm,HttpStatus.OK);}
			else {
				return new ResponseEntity<>("No data for the requested id",HttpStatus.NOT_FOUND);
			}
			}
			catch(Exception e) {
				return new ResponseEntity<Object>("No data found for id ",HttpStatus.NOT_FOUND);
			}
		}
	
	public ResponseEntity<Object> updateStudent(StudentModel smodel) {
		try {
		StudentModel sm = sr.findById(smodel.getId()).get();
		sm.setName(smodel.getName());
		sm.setCity(smodel.getCity());
		
		sr.save(sm);
		return new ResponseEntity<>(sm,HttpStatus.OK);	}
		catch(Exception e) {
			return new ResponseEntity<>("no data found for the id to update",HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Object> saveSudent(StudentModel smodel) {
		try {
			
			smodel.setId(getMaxId()+1);
			StudentModel sm=sr.save(smodel);
			return new ResponseEntity<>(sm,HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<>("Cannot Save student",HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	public ResponseEntity<Object> deleteStudent(int id) {
		try {
			if(id>0 && id<=getMaxId()) {
				Optional<StudentModel> sm=sr.findById(id);
				sr.deleteById(id);
				return new ResponseEntity<>(sm,HttpStatus.ACCEPTED);
			}
			else {return new ResponseEntity<>("id must be greater than ",HttpStatus.NOT_FOUND);}
			}catch(Exception e) {
				return new ResponseEntity<>("Cannot delete student",HttpStatus.NOT_FOUND);
			}
			
	}
	
	public int getMaxId() {
		StudentModel sm=null;
		int maxId=0;
		for(StudentModel i:sr.findAll()) {
			sm=i;
			maxId=sm.getId();
		}
		return maxId;
	}
	

}






