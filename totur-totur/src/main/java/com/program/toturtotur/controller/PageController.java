package com.program.toturtotur.controller;

import com.program.toturtotur.comment.LayUIPageBean;
import com.program.toturtotur.service.StudentService;
import com.program.toturtotur.service.TeacherService;
import com.program.tutorcommon.entity.Student;
import com.program.tutorcommon.entity.Teacher;
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

    @Autowired
    private TeacherService teacherService;

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
        Student pStudent = studentService.findOne(id);
        List<Student> students = new ArrayList<>();
        students.add(pStudent);
        layUIPageBean.setData(students);
        model.addAttribute("bean",layUIPageBean);
        return "student/studentDetails";
    }

    @RequestMapping(value = "/teacherDetailsPage")
    public String teachersDetialPage(@RequestParam(value = "id") Integer id,Model model){
        LayUIPageBean<Teacher> layUIPageBean = new LayUIPageBean<Teacher>();
        layUIPageBean.setCode(0);
        layUIPageBean.setCount(teacherService.getCount());
        layUIPageBean.setMsg("查询成功2");
        Teacher pTeacher = teacherService.findOne(id);
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(pTeacher);
        layUIPageBean.setData(teachers);
        model.addAttribute("beanTea",layUIPageBean);
        return "teacher/teacherDetails";
    }

}
