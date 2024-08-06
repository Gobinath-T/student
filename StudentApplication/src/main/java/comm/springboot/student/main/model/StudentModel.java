package comm.springboot.student.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentModel {
	@Id
	int id;
	String name;
	String city;
	public StudentModel(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	
	
	public StudentModel() {
		
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
