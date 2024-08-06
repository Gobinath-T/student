package com.springboot.student.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.student.main.model.StudentModel;
import com.springboot.student.main.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	
	@Autowired
	StudentService ss;
	
	@GetMapping("/stud")
	public ResponseEntity<?> studentList() {
		return ss.getStudents();
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Object> getStudentById(@PathVariable int id){
		return ss.getById(id);
	}
	
	@GetMapping("/students/getName/{name}")
	public ResponseEntity<Object> getStudentByName(@PathVariable String name){
		return ss.getByName(name);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveStudent(@RequestBody StudentModel smodel) {
		return ss.saveSudent(smodel);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateStudent(@RequestBody StudentModel smodel) {
		return ss.updateStudent(smodel);
	}

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteStudent(@PathVariable int id) {
		return ss.deleteStudent(id);
	}
	
	

}
