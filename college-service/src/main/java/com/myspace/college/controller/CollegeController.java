package com.myspace.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspace.college.entity.College;
import com.myspace.college.service.CollegeService;

@RestController
@RequestMapping("/college")
public class CollegeController {
	
	@GetMapping("/getCollege")
	public String getColleges(){
		return "Colleges";
		
	}

	@Autowired
	private CollegeService collegeService;
	
	@GetMapping("/getCollegeById/{id}")
	public College getCollegeById(@PathVariable("id") int id) {
		System.out.println("id +++++++++ " + id);
		return collegeService.getCollegeById(id);
	}
	
	@GetMapping("/getColleges")
	public List<College> getAllColleges() {
		return collegeService.getAllColleges();
	}
	
	@PostMapping("/saveCollege")
	public College getCollegerById(@RequestBody College College) {
		collegeService.saveCollege(College);
		return College;
	}
}
