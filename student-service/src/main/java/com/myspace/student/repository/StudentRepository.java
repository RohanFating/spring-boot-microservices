package com.myspace.student.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myspace.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Id> {

	public Student findById(int id);
}
