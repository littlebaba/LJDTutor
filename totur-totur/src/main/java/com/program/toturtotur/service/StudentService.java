package com.program.toturtotur.service;

import com.program.toturtotur.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

/**
 * @author Li on 2018/2/2.
 */
public interface StudentService {

    Page<Student> fetchTopTen(Sort sort);

    Page<Student> findByPage(Student student,int pageNo,int limit);

    long getCount();

    Student findOne(Integer id);

    Student save(Student stu);
}
