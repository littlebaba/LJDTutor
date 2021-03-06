package com.program.toturtotur.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.program.toturtotur.utils.Constants;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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


    @ManyToOne
    @JoinColumn(nullable = false,name = "area_id")
    private Area area;

    private String areaDes;

    //学员信息
    private Integer sex = 0; //0:男 1：女

    @ManyToOne
    @JoinColumn(nullable = false,name = "grade_id",columnDefinition = "1")
    private Grade grade;


    private String classTime;

    private String studentDes;
    //对教员的要求

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tutor_student_teacher",
    joinColumns = {@JoinColumn(name = "student_id",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name="teacher_id",referencedColumnName = "id")})
    private Set<Teacher> teachers = new HashSet<Teacher>();


    private Integer reqTeaSex = 2;//0:男 1：女 2：男女均可

    private String reqTeaDes;

    @Column(nullable = false)
    private String pay;


    @Column(nullable = false)
    @JsonFormat(pattern = Constants.DATETIME_FORMAT, timezone = "GMT+8")
    @CreatedDate
    private Date initDate = new Date();

    @Column(columnDefinition = "default 0")
    private Integer state;//0:新家教1：正在试讲2：已经签约

    private String subject;


    private String qq;

    private String timesPerWeek;
    private String hoursPerTime;
    //具体上课安排
    private String classArr;

    public String getClassArr() {
        return classArr;
    }

    public void setClassArr(String classArr) {
        this.classArr = classArr;
    }

    public String getTimesPerWeek() {
        return timesPerWeek;
    }

    public void setTimesPerWeek(String timesPerWeek) {
        this.timesPerWeek = timesPerWeek;
    }

    public String getHoursPerTime() {
        return hoursPerTime;
    }

    public void setHoursPerTime(String hoursPerTime) {
        this.hoursPerTime = hoursPerTime;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }



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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
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

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
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
