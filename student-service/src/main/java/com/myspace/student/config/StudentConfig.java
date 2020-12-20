package com.myspace.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.myspace.student.service.StudentService;

@Configuration
public class StudentConfig {
	
	@Bean
	public StudentService getStudentService() {
		return new StudentService();
	}

}
