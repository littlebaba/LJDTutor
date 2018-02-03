package com.program.tutorcommon.base;

import com.program.tutorcommon.dao.StudentDao;
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
public class BaseServiceImplTest {

    @Autowired
    BaseServiceImpl<StudentDao, Student> baseService;


    @Test
    public void save() {
    }

    @Test
    public void findAll() {
        List<Student> all = baseService.repository.findAll();
        System.out.println(all.get(0).toString());
    }

    @Test
    public void getCount() {
    }
}