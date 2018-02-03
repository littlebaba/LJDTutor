package com.program.toturtotur.service.impl;

import com.program.tutorcommon.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Li on 2018/2/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {

    @Autowired
    StudentServiceImpl studentService;

    @Test
    public void test1(){
        List<Student> s = studentService.repository.findAll();
        System.out.println(s.get(0).toString());
    }

}