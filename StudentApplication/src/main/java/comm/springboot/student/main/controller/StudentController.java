package comm.springboot.student.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	
	@GetMapping("/students")
	public String studentList() {
		return null;
	}
	
	@GetMapping("/student/{id}")
	public String getStudentById(@PathVariable int id){
		return null;
	}
	
	@GetMapping("/student/{name}")
	public String getStudentByName(@PathVariable String id){
		return null;
	}
	
	

}
