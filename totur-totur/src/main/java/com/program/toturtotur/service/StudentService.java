package com.program.toturtotur.service;

import com.program.tutorcommon.base.BaseService;
import com.program.tutorcommon.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author Li on 2018/2/2.
 */
public interface StudentService extends BaseService<Student>{

    Page<Student> fetchTopTen(Sort sort);

    Page<Student> findByPage(Student student,int pageNo,int limit);
}
