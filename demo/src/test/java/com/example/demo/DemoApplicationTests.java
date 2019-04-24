package com.example.demo;

import com.example.demo.entity.JobAndTrigger;
import com.example.demo.entity.Student;
import com.example.demo.service.IJobAndTriggerService;
import com.example.demo.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private StudentService studentService;
	@Autowired
	private IJobAndTriggerService iJobAndTriggerService;

	@Test
	public void contextLoads() {
			List<Student> studentList1=studentService.selectStudentList();
			studentList1.forEach(s->{
				System.out.println(s);
			});
			List<Student> studentList2=studentService.selectStudentList2();
			studentList2.forEach(s2 -> System.out.println(s2));
		PageInfo<JobAndTrigger> t=iJobAndTriggerService.getJobAndTriggerDetails(1,10);
		System.out.println(t);
	}


}
