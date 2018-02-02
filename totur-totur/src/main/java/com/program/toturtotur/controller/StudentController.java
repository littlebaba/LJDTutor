package com.program.toturtotur.controller;

import com.program.toturtotur.comment.LayUIPageBean;
import com.program.tutorcommon.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li on 2018/2/2.
 */
@RestController
public class StudentController {

    @RequestMapping("/studentList")
    public LayUIPageBean getStudents(int page,int limit){
        LayUIPageBean<Student> layUIPageBean = new LayUIPageBean<Student>();
        layUIPageBean.setPage(page);
        layUIPageBean.setLimit(limit);
        layUIPageBean.setCode(200);
        layUIPageBean.setMsg("查询成功");

        return layUIPageBean;
    }

}
