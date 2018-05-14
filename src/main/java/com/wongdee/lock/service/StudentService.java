package com.wongdee.lock.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.wongdee.lock.domain.StudentMapper;

public class StudentService {
	
	@Autowired
	private StudentMapper studentMapper;

}
