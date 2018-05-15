package com.wongdee.lock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.wongdee.lock.domain.Student;
import com.wongdee.lock.domain.StudentMapper;

@Service
public class StudentService {
	
	@Autowired
	private StudentMapper studentMapper;

	public String getStudentById(Long sid) {
		Student stu = studentMapper.getStudentById(sid);
		JSONObject stuJson= new JSONObject();
		stuJson.put("sid", stu.getSid());
		stuJson.put("sname", stu.getSname());
		stuJson.put("scode", stu.getScode());
		stuJson.put("gender", stu.getGender());
		stuJson.put("phone", stu.getPhone());
		return stuJson.toJSONString();
	}

	public Integer updateStudent(Student student, Integer version) {
		return studentMapper.updateStudent(student, version);
	}

}
