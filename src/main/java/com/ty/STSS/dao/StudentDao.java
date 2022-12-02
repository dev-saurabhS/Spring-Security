package com.ty.STSS.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.STSS.repository.StudentRepository;
import com.ty.STSS.dto.Student;

@Repository
public class StudentDao {
	@Autowired
	StudentRepository studentRepository;

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student deleteStudent(Student student) {
		studentRepository.delete(student);
		return student;
	}

	public Optional<Student> getStudentById(int id) {
		return studentRepository.findById(id);
	}

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}
	
	public Student findByName(String name) {
		return studentRepository.findByName(name);
	}
}
