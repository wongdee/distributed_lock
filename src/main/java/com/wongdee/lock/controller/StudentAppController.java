package com.wongdee.lock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wongdee.lock.annotation.Lock;
import com.wongdee.lock.service.StudentService;

@RestController
public class StudentAppController {

	@Autowired
	private StudentService studentService;
	
	@Lock
	@RequestMapping("/student.get")
	public String getStudentById(Long sid){
		return studentService.getStudentById(sid);
	}
	

}
