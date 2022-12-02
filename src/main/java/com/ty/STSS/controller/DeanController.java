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

import com.ty.STSS.dao.DeanDao;
import com.ty.STSS.dto.Dean;

@RestController
@RequestMapping("/deans")
public class DeanController {

	@Autowired
	private DeanDao deanDao;

	@PostMapping()
	public Dean saveDean(@RequestBody Dean dean) {
		return deanDao.saveDean(dean);
	}

	@GetMapping("/{id}")
	public Dean getById(@PathVariable int id) {
		Optional<Dean> opt = deanDao.getById(id);
		if (opt.isPresent())
			return opt.get();
		else
			return null;
	}

	@DeleteMapping("/{id}")
	public Dean deleteDean(@PathVariable int id) {
		Optional<Dean> opt = deanDao.getById(id);
		if (opt.isPresent()) {
			return deanDao.deleteDean(opt.get());
		} else
			return null;
	}

	@GetMapping()
	public List<Dean> getAll() {
		return deanDao.getAll();
	}

}
