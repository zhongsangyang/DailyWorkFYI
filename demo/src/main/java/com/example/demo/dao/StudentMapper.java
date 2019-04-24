package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface StudentMapper {
    int deleteByPrimaryKey(Long studid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long studid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectStudentList();
}