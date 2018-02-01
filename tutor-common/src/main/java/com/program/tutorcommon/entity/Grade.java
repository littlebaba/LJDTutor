package com.program.tutorcommon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Li on 2018/1/31.
 */
@Entity
@Table(name = "totur_grade")
public class Grade {
    @Id
    @GeneratedValue
    private Integer id;

    private String grade;
}
