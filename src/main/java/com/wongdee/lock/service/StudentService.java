package com.wongdee.lock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wongdee.lock.domain.StudentMapper;

@Service
public class StudentService {
	
	@Autowired
	private StudentMapper studentMapper;

}
