package com.program.toturtotur.controller;

import com.program.toturtotur.comment.LayUIPageBean;
import com.program.toturtotur.service.StudentService;
import com.program.tutorcommon.base.BaseController;
import com.program.tutorcommon.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li on 2018/2/2.
 */
@RestController
@RequestMapping("/students")
public class StudentController extends BaseController{

    @Autowired
    private StudentService studentService;

    @GetMapping
    public LayUIPageBean getStudents(){
        LayUIPageBean<Student> layUIPageBean = new LayUIPageBean<Student>();
        layUIPageBean.setCode(0);
        layUIPageBean.setCount(studentService.getCount());
        layUIPageBean.setMsg("查询成功1");
        Sort sort = new Sort(Sort.Direction.DESC,"initDate");
        Page<Student> pStudents = studentService.fetchTopTen(sort);
        List<Student> topTenS = pStudents.getContent();
        layUIPageBean.setData(topTenS);
        return layUIPageBean;
    }

}












