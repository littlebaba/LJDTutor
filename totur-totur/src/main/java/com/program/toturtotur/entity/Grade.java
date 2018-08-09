package com.program.toturtotur.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Li on 2018/1/31.
 */
@Entity
@Table(name = "totur_grade")
public class Grade implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    private String grade;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


}
