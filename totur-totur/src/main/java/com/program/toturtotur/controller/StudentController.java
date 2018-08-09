package com.program.toturtotur.controller;

import com.program.toturtotur.entity.LayUIPageBean;
import com.program.toturtotur.entity.Student;
import com.program.toturtotur.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Li on 2018/2/2.
 */
@RestController
@RequestMapping("/students")
public class StudentController{

    @Autowired
    private StudentService studentService;

    @GetMapping
    public LayUIPageBean getStudents() {
        LayUIPageBean<Student> layUIPageBean = new LayUIPageBean<Student>();
        layUIPageBean.setCode(0);
        layUIPageBean.setCount(studentService.getCount());
        layUIPageBean.setMsg("查询成功1");
        Sort sort = new Sort(Sort.Direction.DESC, "initDate");
        Page<Student> pStudents = studentService.fetchTopTen(sort);
        List<Student> topTenS = pStudents.getContent();
        layUIPageBean.setData(topTenS);
        return layUIPageBean;
    }

    @GetMapping(value = "/all")
    public LayUIPageBean getAllStudents(Student student,
                                        @RequestParam(required = false, defaultValue = "1") int page,
                                        @RequestParam(required = false, defaultValue = "10") int limit) {
        int pageNo = page % limit-1;
        Page<Student> pageStu = studentService.findByPage(student,pageNo,limit);

        LayUIPageBean<Student> layUIPageBean = new LayUIPageBean<Student>();
        layUIPageBean.setCode(0);
        layUIPageBean.setCount(pageStu.getTotalElements());
        layUIPageBean.setMsg("查询成功2");
        layUIPageBean.setData(pageStu.getContent());
        return layUIPageBean;
    }


}












