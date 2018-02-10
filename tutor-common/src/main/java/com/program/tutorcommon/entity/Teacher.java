package com.program.tutorcommon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.program.tutorcommon.utils.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Li on 2018/1/31.
 */
@Entity
@Table(name = "totur_teacher")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    //注册信息
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    //教员基本信息
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer sex;//0:男，1：女

    @Column(nullable = false)
    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = "GMT+8")
    private Date birthday;

    @Column(nullable = false)
    @JsonFormat(pattern = Constants.DATETIME_FORMAT, timezone = "GMT+8")
    private Date initDate;


    @ManyToOne
    @JoinColumn(nullable = false,name = "area_id")
    private Area area;

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    private String birthPlace;


    private String education;

    @Column(nullable = false)
    private String IdNumber;

    private String profession;

    private String graduatedSchool;

    //联系方式
    private String livePlace;

    private String workPlace;

    private String tel;
    @Column(nullable = false)
    private String mobile;

    private String QQ;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String contactAddr;


    //学生与教员的关联关系
    @JsonIgnore
    @ManyToMany(mappedBy = "teachers")
    private Set<Student> students = new HashSet<Student>();



    private String selfDes;
    private String teachSubjects;

    private String canTeachTime;

    private String salaryRequire;

    public String getSalaryRequire() {
        return salaryRequire;
    }

    public void setSalaryRequire(String salaryRequire) {
        this.salaryRequire = salaryRequire;
    }

    public String getTeachSubjects() {
        return teachSubjects;
    }

    public void setTeachSubjects(String teachSubjects) {
        this.teachSubjects = teachSubjects;
    }

    public String getCanTeachTime() {
        return canTeachTime;
    }

    public void setCanTeachTime(String canTeachTime) {
        this.canTeachTime = canTeachTime;
    }

    public String getSelfDes() {
        return selfDes;
    }

    public void setSelfDes(String selfDes) {
        this.selfDes = selfDes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public String getIdNumber() {
        return IdNumber;
    }

    public void setIdNumber(String idNumber) {
        IdNumber = idNumber;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
    }

    public String getLivePlace() {
        return livePlace;
    }

    public void setLivePlace(String livePlace) {
        this.livePlace = livePlace;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactAddr() {
        return contactAddr;
    }

    public void setContactAddr(String contactAddr) {
        this.contactAddr = contactAddr;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", initDate=" + initDate +
                ", birthPlace='" + birthPlace + '\'' +
                ", education='" + education + '\'' +
                ", IdNumber='" + IdNumber + '\'' +
                ", profession='" + profession + '\'' +
                ", graduatedSchool='" + graduatedSchool + '\'' +
                ", livePlace='" + livePlace + '\'' +
                ", workPlace='" + workPlace + '\'' +
                ", tel='" + tel + '\'' +
                ", mobile='" + mobile + '\'' +
                ", QQ='" + QQ + '\'' +
                ", email='" + email + '\'' +
                ", contactAddr='" + contactAddr + '\'' +
                '}';
    }
}
