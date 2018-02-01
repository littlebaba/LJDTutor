package com.program.tutorcommon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Li on 2018/1/31.
 */
@Entity
@Table(name = "totur_subject")
public class Subject implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    private String subject;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
