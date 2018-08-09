package com.program.toturtotur.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.program.toturtotur.utils.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Li on 2018/2/14.
 */
@Entity
@Table(name = "totur_user")
public class User implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;

    private String email;

    // 头像
    private String icon ="http://127.0.0.1/images/upload/default.png";

    // 个人签名
    private String signature;

    private String username;
    @JsonIgnore
    private String password;


    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = "GMT+8")
    private Date initTime;

    @JsonIgnore
    @JoinTable(name = "totur_user_role",
            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")})
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Role> roles = new HashSet<Role>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Date getInitTime() {
        return initTime;
    }

    public void setInitTime(Date initTime) {
        this.initTime = initTime;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
