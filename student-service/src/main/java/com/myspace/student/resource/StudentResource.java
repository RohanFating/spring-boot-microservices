package com.myspace.student.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.myspace.student.entity.College;
import com.myspace.student.entity.CollegeStudent;
import com.myspace.student.entity.Student;
import com.myspace.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentResource {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getStudentbyId/{id}")
	public Student getUserById(@PathVariable("id") int id) {
		System.out.println("id +++++++++ " + id);
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@PostMapping("/saveStudent")
	public Student getUserById(@RequestBody Student student) {
		studentService.saveStudent(student);
		return student;
	}
	
	@GetMapping("/getStudentDetailsbyId/{id}")
	public CollegeStudent getStudentDetailsbyId(@PathVariable("id") int id) {
		System.out.println("id +++++++++ " + id);
		CollegeStudent cs = new CollegeStudent();
		Student student = studentService.getStudentById(id);
		
		College college = restTemplate.getForObject("http://COLLEGE-SERVICE/college/getCollegeById/"+ student.getCollegeId(), College.class);
		cs.setCollege(college);
		cs.setStudent(student);
		return cs;
	}

}
