package com.ty.STSS.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.STSS.repository.TeacherRepository;
import com.ty.STSS.dto.Teacher;

@Repository
public class TeacherDao {
	@Autowired
	TeacherRepository teacherRepository;

	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	public Teacher deleteTeacher(Teacher teacher) {
		teacherRepository.delete(teacher);
		return teacher;
	}

	public Optional<Teacher> getTeacherById(int id) {
		return teacherRepository.findById(id);
	}

	public List<Teacher> getAllTeacher() {
		return teacherRepository.findAll();
	}
}
