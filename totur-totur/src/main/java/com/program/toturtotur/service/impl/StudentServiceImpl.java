package com.program.toturtotur.service.impl;

import com.program.toturtotur.service.StudentService;
import com.program.tutorcommon.base.BaseServiceImpl;
import com.program.tutorcommon.dao.StudentDao;
import com.program.tutorcommon.entity.Student;
import org.springframework.stereotype.Service;

/**
 * @author Li on 2018/2/2.
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<StudentDao,Student> implements StudentService{

}
