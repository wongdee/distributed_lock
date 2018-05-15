package com.wongdee.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wongdee.lock.domain.Student;
import com.wongdee.lock.domain.StudentMapper;
import com.wongdee.lock.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistributedLockApplicationTests {
	
	private static ExecutorService executor = Executors.newFixedThreadPool(10);

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Test
	public void getStudent(){
		String studentById = studentService.getStudentById(1L);
		System.out.println(studentById);
	}
	
	@Test
	public void updateStudent(){
		CountDownLatch countDownLatch = new CountDownLatch(6);
		
		Student stu = studentMapper.getStudentById(1L);
		Integer version = stu.getVersion();
		
		for (int i = 0; i < 6; i++) {
			int j = i;
			executor.submit((Runnable) () -> {
				Student student = new Student();
				student.setSid(1L);
				student.setScode("20180010" + j);
				student.setVersion(version+1);
				studentService.updateStudent(student, version);
				countDownLatch.countDown();
			} );
		}
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("执行完成！");
		
	}

}
