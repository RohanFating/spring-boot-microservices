package com.myspace.college.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myspace.college.entity.College;

public interface CollegeRepository extends JpaRepository<College, Id> { 

	public College findById(int id);
	public College findByCollegeId(int id);
}
