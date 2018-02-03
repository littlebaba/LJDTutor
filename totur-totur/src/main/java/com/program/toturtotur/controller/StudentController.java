package com.program.toturtotur.controller;

import com.program.toturtotur.comment.LayUIPageBean;
import com.program.toturtotur.service.StudentService;
import com.program.tutorcommon.base.BaseController;
import com.program.tutorcommon.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Li on 2018/2/2.
 */
@RestController
@RequestMapping("/students")
public class StudentController extends BaseController{

    @Autowired
    private StudentService studentService;

    @GetMapping
    public LayUIPageBean getStudents(
//            @RequestParam(required = false, defaultValue = "1")int page,
//            @RequestParam(required = false, defaultValue = "10")int limit
    ){
        LayUIPageBean<Student> layUIPageBean = new LayUIPageBean<Student>();
//        layUIPageBean.setPage(page);
//        layUIPageBean.setLimit(limit);
        layUIPageBean.setCode(0);
        layUIPageBean.setCount(studentService.getCount());
        layUIPageBean.setMsg("查询成功1");
        layUIPageBean.setData(studentService.findAll());
        return layUIPageBean;

    }


}
