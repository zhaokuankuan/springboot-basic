package com.kk.springbootbasic.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Mr.kk
 * 用户的详情表
 * */
@Entity
public class UserDetail implements Serializable{
    private static  final  long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String userId;
    @Column(nullable = true)
    private String address;
    @Column(nullable = true)
    private String hobby;

    public UserDetail() {
    }

    public UserDetail(String userId, String address, String hobby) {
        this.userId = userId;
        this.address = address;
        this.hobby = hobby;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }

    public String getHobby() {
        return hobby;
    }
}
