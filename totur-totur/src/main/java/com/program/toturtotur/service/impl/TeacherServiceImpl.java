package com.program.toturtotur.service.impl;

import com.program.toturtotur.service.StudentService;
import com.program.toturtotur.service.TeacherService;
import com.program.tutorcommon.base.BaseServiceImpl;
import com.program.tutorcommon.dao.StudentDao;
import com.program.tutorcommon.dao.TeacherDao;
import com.program.tutorcommon.entity.Student;
import com.program.tutorcommon.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author Li on 2018/2/2.
 */
@Service
public class TeacherServiceImpl extends BaseServiceImpl<TeacherDao,Teacher> implements TeacherService{


    @Override
    public Page<Teacher> fetchTopTen(Sort sort) {
        Pageable pg = new PageRequest(0,10,sort);
        return repository.findAll(pg);
    }
}
