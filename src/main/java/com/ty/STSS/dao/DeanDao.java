package com.ty.STSS.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.STSS.dto.Dean;
import com.ty.STSS.repository.DeanRepository;

@Repository
public class DeanDao {
	@Autowired
	private DeanRepository deanRepository;

	public Dean saveDean(Dean dean) {
		return deanRepository.save(dean);
	}

	public Optional<Dean> getById(int id) {
		return deanRepository.findById(id);
	}

	public List<Dean> getAll() {
		return deanRepository.findAll();
	}

	public Dean deleteDean(Dean dean) {
		deanRepository.delete(dean);
		return dean;
	}
	
	

}
