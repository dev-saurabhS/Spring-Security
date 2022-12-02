package com.ty.STSS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.STSS.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	Student findByName(String name);
}
