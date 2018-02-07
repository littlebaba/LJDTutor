package com.program.toturtotur.controller;

import com.program.toturtotur.comment.LayUIPageBean;
import com.program.toturtotur.service.StudentService;
import com.program.toturtotur.service.TeacherService;
import com.program.tutorcommon.entity.Student;
import com.program.tutorcommon.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Li on 2018/2/5.
 */
@RestController
@RequestMapping(value = "/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public LayUIPageBean getTeachers(){
        LayUIPageBean<Teacher> layUIPageBean = new LayUIPageBean<Teacher>();
        layUIPageBean.setCode(0);
        layUIPageBean.setCount(teacherService.getCount());
        layUIPageBean.setMsg("查询成功1");
        Sort sort = new Sort(Sort.Direction.DESC,"initDate");
        Page<Teacher> pStudents = teacherService.fetchTopTen(sort);
        List<Teacher> topTenS = pStudents.getContent();
        layUIPageBean.setData(topTenS);
        return layUIPageBean;

    }
}
