package com.program.toturtotur.service;


import com.program.toturtotur.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

/**
 * @author Li on 2018/2/2.
 */
public interface TeacherService {

    Page<Teacher> fetchTopTen(Sort sort);
    Page<Teacher> findByPage(Teacher teacher,int pageNo,int limit);

    long getCount();

    Teacher findOne(Integer id);

    Teacher save(Teacher teach);
}
