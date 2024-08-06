package com.springboot.student.main.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.student.main.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Integer> {

	public StudentModel findByName(String name);

}
