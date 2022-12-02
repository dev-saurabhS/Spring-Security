package com.ty.STSS.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@javax.persistence.Entity
@Getter
@Setter
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gender;
	private String email;
	private String role;
//	@Convert(converter = AesEncryptor.class)
	private String password;

}
