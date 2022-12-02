package com.ty.STSS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.STSS.dto.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	Teacher findByName(String name);
}
