package com.test.first.domain;

import java.io.Serializable;

/**
 * Created by liuning on 2017/9/21.
 */
public class User implements Serializable {

    //编号
    private Long id;
    //用户编号
    private Long userid;
    //用户名称
    private String username;
    //密码
    private String password;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
