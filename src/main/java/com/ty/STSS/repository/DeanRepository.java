package com.ty.STSS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.STSS.dto.Dean;

public interface DeanRepository extends JpaRepository<Dean, Integer>{
		public Dean findByName(String name);
}
