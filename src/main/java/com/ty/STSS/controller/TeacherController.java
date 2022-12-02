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
import org.springframework.web.bind.annotation.RestController;

import com.ty.STSS.dao.TeacherDao;
import com.ty.STSS.dto.Teacher;

@RestController
@RequestMapping("teachers")
public class TeacherController {
	@Autowired
	private TeacherDao dao;

	@PostMapping()
	public Teacher saveTeacher(@RequestBody Teacher teacher) {
		return dao.saveTeacher(teacher);
	}

	@DeleteMapping("/{id}")
	public Teacher deleteTeacher(@PathVariable int id) {
		Optional<Teacher> opt = dao.getTeacherById(id);
		if (opt.isPresent())
			return dao.deleteTeacher(opt.get());
		else
			return null;
	}

	@GetMapping("/{id}")
	public Teacher getById(@PathVariable int id) {
		Optional<Teacher> opt = dao.getTeacherById(id);
		if (opt.isPresent())
			return opt.get();
		else
			return null;
	}

	@GetMapping()
	public List<Teacher> getAllTeacher() {
		return dao.getAllTeacher();
	}

}
