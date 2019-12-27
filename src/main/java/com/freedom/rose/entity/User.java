package com.freedom.rose.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)//自动完成创建时间和修改时间的生成
public class User implements Serializable {
    private String id;
    private String code;
    private String name;
    private String password;
    private String gender;
    private String phone;
    private String email;
    private String userGroup;
    private String orgID;
    private String avatar;
    private String secLevel;
    private Date createdTime;
    private Date lastModifiedTime;
    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public String getOrgID() {
        return orgID;
    }

    public void setOrgID(String orgID) {
        this.orgID = orgID;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSecLevel() {
        return secLevel;
    }

    public void setSecLevel(String secLevel) {
        this.secLevel = secLevel;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User(String id, String code, String name, String password, String gender, String phone, String email, String userGroup, String orgID, String avatar, String secLevel, Date createdTime, Date lastModifiedTime, int status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.userGroup = userGroup;
        this.orgID = orgID;
        this.avatar = avatar;
        this.secLevel = secLevel;
        this.createdTime = createdTime;
        this.lastModifiedTime = lastModifiedTime;
        this.status = status;
    }

    public User() {
    }
}
