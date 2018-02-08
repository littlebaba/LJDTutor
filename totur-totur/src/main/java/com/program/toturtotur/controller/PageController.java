package com.program.toturtotur.controller;

import com.program.toturtotur.comment.LayUIPageBean;
import com.program.toturtotur.service.StudentService;
import com.program.tutorcommon.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li on 2018/2/2.
 */
@Controller
public class PageController {

    /**
     * 主页面
     * @return
     */


    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/studentsPage")
    public String studentsPage(){
        return "student/students";
    }

    @RequestMapping(value = "/studentDetailsPage")
    public String studentsDetialPage(@RequestParam(value = "id") Integer id, Model model){
        LayUIPageBean<Student> layUIPageBean = new LayUIPageBean<Student>();
        layUIPageBean.setCode(0);
        layUIPageBean.setCount(studentService.getCount());
        layUIPageBean.setMsg("查询成功1");
        Student pStudents = studentService.findOne(id);
        List<Student> students = new ArrayList<>();
        students.add(pStudents);
        layUIPageBean.setData(students);
        model.addAttribute("bean",layUIPageBean);
        return "student/studentDetails";
    }

}
