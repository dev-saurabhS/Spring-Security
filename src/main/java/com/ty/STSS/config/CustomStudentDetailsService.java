package com.ty.STSS.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ty.STSS.dto.Dean;
import com.ty.STSS.dto.Student;
import com.ty.STSS.dto.Teacher;
import com.ty.STSS.repository.DeanRepository;
import com.ty.STSS.repository.StudentRepository;
import com.ty.STSS.repository.TeacherRepository;

@Service
public class CustomStudentDetailsService implements UserDetailsService {

    @Autowired
    private TeacherRepository  teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DeanRepository deanRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Teacher teacher  = teacherRepository.findByName(name);
        if(teacher ==null) {
        	Student student = studentRepository.findByName(name);
        	if (student==null) {
        		Dean dean=deanRepository.findByName(name);
        		if(dean!=null) {
        			return new CustomDeanDetails(dean);
        		}
        		return new CustomStudentDetails(student);
			}
            throw new UsernameNotFoundException("User Not Found");
        }
        return new CustomTeacherDetails(teacher);
    }
//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//
//        Student student  = studentRepository.findByName(name);
//        if(student ==null) {
//            throw new UsernameNotFoundException("User Not Found");
//        }
//        return new CustomStudentDetails(student);
//    }
}