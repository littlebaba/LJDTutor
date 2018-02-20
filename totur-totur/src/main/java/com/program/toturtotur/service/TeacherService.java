package com.program.toturtotur.service;

import com.program.tutorcommon.base.BaseService;
import com.program.tutorcommon.entity.Student;
import com.program.tutorcommon.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

/**
 * @author Li on 2018/2/2.
 */
public interface TeacherService extends BaseService<Teacher>{

    Page<Teacher> fetchTopTen(Sort sort);
    Page<Teacher> findByPage(Teacher teacher,int pageNo,int limit);
}
