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
@Table(name = "totur_area")
public class Area implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;

    private String area;

    public Area(){

    }
    public Area(String area) {
        this.area = area;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
