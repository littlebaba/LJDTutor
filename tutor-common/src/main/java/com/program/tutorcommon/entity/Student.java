package com.program.tutorcommon.entity;

import javax.persistence.*;

/**
 * @author Li on 2018/1/31.
 *
 * 学生
 */
@Entity
@Table(name = "totur_student")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    //联系人信息
    @Column(nullable = false)
    private String contactName;


    private String fixedTel;

    @Column(nullable = false)
    private String mobilePhone;

    private String area;

    private String areaDes;

    //学员信息
    private Integer sex = 0; //0:男 1：女

    @Column(nullable = false)
    private String grade;

    private String classTime;

    private String studentDes;
    //对教员的要求


    private Integer reqTeaSex = 2;////0:男 1：女 2：男女均可

    private String reqTeaDes;

    @Column(nullable = false)
    private String pay;



}
