package com.example.demo.service.impl;

import com.example.demo.dao.StudentMapper;
import com.example.demo.dataSource.DataSource;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;
    @Override
    @DataSource("testData1")
    public List<Student> selectStudentList() {
        return studentMapper.selectStudentList();
    }
    @DataSource("testData2")
    @Override
    public List<Student> selectStudentList2() {
        return studentMapper.selectStudentList();
    }

}
