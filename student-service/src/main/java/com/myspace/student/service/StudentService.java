package com.myspace.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.myspace.student.entity.Student;
import com.myspace.student.repository.StudentRepository;

public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public Student saveStudent( Student student ) {
		return studentRepository.save(student);
	}
	
	public Student getStudentById(int id) {
		return studentRepository.findById(id);
	}

}
