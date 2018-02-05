package com.program.toturtotur.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Li on 2018/2/2.
 */
@Controller
public class PageController {

    /**
     * 主页面
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/studentsPage")
    public String StudentsPage(){
        return "student/students";
    }
}
