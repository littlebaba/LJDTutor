package com.program.tutorcommon.dao;

import com.program.tutorcommon.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Li on 2018/2/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void findStudentByMobile() {
        Student s = (Student) studentDao.findStudentByMobile("18209315709");
        System.out.println(s.toString());
    }
}