package com.program.toturtotur.controller;

import com.program.toturtotur.entity.LayUIPageBean;
import com.program.toturtotur.dao.UserDao;
import com.program.toturtotur.entity.Student;
import com.program.toturtotur.entity.Teacher;
import com.program.toturtotur.entity.User;
import com.program.toturtotur.service.StudentService;
import com.program.toturtotur.service.TeacherService;
import com.program.toturtotur.service.UserService;
import com.program.toturtotur.utils.SecurityUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Li on 2018/2/2.
 */
@Controller
public class PageController {

    Log logger = LogFactory.getLog(PageController.class);

    /**
     * 主页面
     * @return
     */
    @Autowired
    UserDao userDao;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private UserService userService;

    @RequestMapping(value ={"/","/home"},method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/studentsPage")
    public String studentsPage(){
        return "student/students";
    }

    @RequestMapping(value = "/teachersPage")
    public String teachersPage(){
        return "teacher/teachers";
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

    @RequestMapping(value = "/stuRegPage")
    public String stuRegPage(){
        return "student/stuReg";
    }

    //teachRegPage
    @RequestMapping(value = "/teachRegPage")
    public String teachRegPage(){
        return "teacher/teachReg";
    }

    @RequestMapping(value = "/stuReg",method = RequestMethod.POST)
    public String stuReg(HttpServletRequest request,Student stu,Model model){
        Student s = studentService.save(stu);
        return "redirect:/home";
    }

    @RequestMapping(value = "/teachRegOne",method = RequestMethod.POST)
    public String teachRegOne(HttpServletRequest request, User user, Model model){
        int u = userService.register(user);
        return "redirect:/teachRegTwo";
    }

    @RequestMapping(value = "/teachRegTwo")
    public String teachRegTwo(){
        return "teacher/teachRegTwo";
    }

    @RequestMapping(value = "/teachReg",method = RequestMethod.POST)
    public String teachReg(HttpServletRequest request,Teacher teach,Model model){
        Teacher t = teacherService.save(teach);
        return "redirect:/home";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }


    @RequestMapping(value = "/loginHandle")
    public String loginHandle(HttpServletRequest request, User user,Model model){
        if (StringUtils.isEmpty(user.getUsername().trim())||StringUtils.isEmpty(user.getPassword().trim())){
            logger.error("用户名或密码不能为空");
            return "login";
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), SecurityUtil.md5Base64(user.getPassword()));
        try {
            subject.login(token);
            session.setAttribute(user.getUsername(),user);
            logger.warn("id: "+session.getId()+"主机 "+session.getHost()+"过期时间： "+session.getTimeout()+"" +
                    "会话启动时间： "+session.getStartTimestamp()+"会话最终访问时间： "+session.getLastAccessTime()
                    +"Keys:  "+session.getAttribute(user.getUsername()));

            return "index";
        } catch (AuthenticationException e) {
            logger.error("用户名密码不正确");
            return "login";
        }
    }

}

