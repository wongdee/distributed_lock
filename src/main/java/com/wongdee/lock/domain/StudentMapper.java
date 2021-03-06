package com.wongdee.lock.domain;

import org.apache.ibatis.annotations.Param;

public interface StudentMapper {

	Student getStudentById(@Param("sid") Long sid);

	Integer updateStudent(@Param("student") Student student, @Param("version") Integer version);

}
