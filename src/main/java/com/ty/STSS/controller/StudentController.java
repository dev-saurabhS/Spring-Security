package com.ty.STSS.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.STSS.dao.StudentDao;
import com.ty.STSS.dto.Student;

@RestController
@RequestMapping("students")
public class StudentController {
	@Autowired
	StudentDao studentDao;

	@PostMapping()
	public Student saveStudent(@RequestBody Student student) {
		return studentDao.saveStudent(student);
	}

	@DeleteMapping("/delete/{id}")
	public Student deleteStudent(@PathVariable int id) {
		Optional<Student> opt = studentDao.getStudentById(id);
		if (opt.isPresent())
			return studentDao.deleteStudent(opt.get());
		else
			return null;
	}
	@GetMapping("/{id}")
	public Student getById(@PathVariable int id) {
		Optional<Student> opt = studentDao.getStudentById(id);
		if (opt.isPresent())
			return opt.get();
		else
			return null;
	}
	@GetMapping()
	public List<Student> getAll() {
		return studentDao.getAllStudent();
	}
	
	@GetMapping("/get")
	public Student findByName(@PathVariable String name) {
		return studentDao.findByName(name);
	}
}
