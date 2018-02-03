package com.program.tutorcommon.del;

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
public class StudentServiceImpllTest {
    @Autowired
    StudentServiceImpll studentServiceImpll;

    @Test
    public void demo(){
        List<Student> s = studentServiceImpll.repository.findAll();
        System.out.println(s.get(0).toString());
    }
}