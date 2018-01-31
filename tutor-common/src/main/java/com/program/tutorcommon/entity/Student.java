package com.program.tutorcommon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.program.tutorcommon.utils.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Li on 2018/1/31.
 * <p>
 * 学生
 */
@Entity
@Table(name = "totur_student")
public class Student implements Serializable {

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


    @Column(nullable = false)
    @JsonFormat(pattern = Constants.DATETIME_FORMAT, timezone = "GMT+8")
    private Date initDate;

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getFixedTel() {
        return fixedTel;
    }

    public void setFixedTel(String fixedTel) {
        this.fixedTel = fixedTel;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaDes() {
        return areaDes;
    }

    public void setAreaDes(String areaDes) {
        this.areaDes = areaDes;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getStudentDes() {
        return studentDes;
    }

    public void setStudentDes(String studentDes) {
        this.studentDes = studentDes;
    }

    public Integer getReqTeaSex() {
        return reqTeaSex;
    }

    public void setReqTeaSex(Integer reqTeaSex) {
        this.reqTeaSex = reqTeaSex;
    }

    public String getReqTeaDes() {
        return reqTeaDes;
    }

    public void setReqTeaDes(String reqTeaDes) {
        this.reqTeaDes = reqTeaDes;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", contactName='" + contactName + '\'' +
                ", fixedTel='" + fixedTel + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", area='" + area + '\'' +
                ", areaDes='" + areaDes + '\'' +
                ", sex=" + sex +
                ", grade='" + grade + '\'' +
                ", classTime='" + classTime + '\'' +
                ", studentDes='" + studentDes + '\'' +
                ", reqTeaSex=" + reqTeaSex +
                ", reqTeaDes='" + reqTeaDes + '\'' +
                ", pay='" + pay + '\'' +
                ", initDate=" + initDate +
                '}';
    }

}
