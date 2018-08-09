package com.program.toturtotur.controller;

import com.program.toturtotur.entity.LayUIPageBean;
import com.program.toturtotur.entity.Teacher;
import com.program.toturtotur.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = "/all")
    public LayUIPageBean getAllTeachers(Teacher teacher,
                                        @RequestParam(required = false, defaultValue = "1") int page,
                                        @RequestParam(required = false, defaultValue = "10") int limit) {
        int pageNo = page % limit-1;
        Page<Teacher> pageStu = teacherService.findByPage(teacher,pageNo,limit);

        LayUIPageBean<Teacher> layUIPageBean = new LayUIPageBean<Teacher>();
        layUIPageBean.setCode(0);
        layUIPageBean.setCount(pageStu.getTotalElements());
        layUIPageBean.setMsg("查询成功2");
        layUIPageBean.setData(pageStu.getContent());
        return layUIPageBean;
    }
}
