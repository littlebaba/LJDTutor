package com.program.tutorcommon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Li on 2018/1/31.
 */
@Entity
@Table(name = "totur_area")
public class Area {

    @Id
    @GeneratedValue
    private Integer id;

    private String area;
}
