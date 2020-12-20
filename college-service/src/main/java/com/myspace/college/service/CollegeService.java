package com.myspace.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspace.college.entity.College;
import com.myspace.college.repository.CollegeRepository;

@Service
public class CollegeService {

	@Autowired
	private CollegeRepository collegeRepository;
	
	public List<College> getAllColleges() {
		return collegeRepository.findAll();
	}
	
	public College saveCollege( College College ) {
		return collegeRepository.save(College);
	}
	
	public College getCollegeById(int id) {
		return collegeRepository.findByCollegeId(id);
	}
	
}
