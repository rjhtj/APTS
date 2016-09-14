package com.APTS.web.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by RuanJH on 2016/8/28.
 */
@Entity
public class Admin {
    private int userId;
    private String username;
    private String password;
    private Integer role;
    private Timestamp loginTime;
    private Integer corpId;
    private Integer ismanager;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role")
    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Basic
    @Column(name = "loginTime")
    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    @Basic
    @Column(name = "corp_id")
    public Integer getCorpId() {
        return corpId;
    }

    public void setCorpId(Integer corpId) {
        this.corpId = corpId;
    }

    @Basic
    @Column(name = "ismanager")
    public Integer getIsmanager() {
        return ismanager;
    }

    public void setIsmanager(Integer ismanager) {
        this.ismanager = ismanager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        if (userId != admin.userId) return false;
        if (username != null ? !username.equals(admin.username) : admin.username != null)
            return false;
        if (password != null ? !password.equals(admin.password) : admin.password != null)
            return false;
        if (role != null ? !role.equals(admin.role) : admin.role != null) return false;
        if (loginTime != null ? !loginTime.equals(admin.loginTime) : admin.loginTime != null)
            return false;
        if (corpId != null ? !corpId.equals(admin.corpId) : admin.corpId != null) return false;
        if (ismanager != null ? !ismanager.equals(admin.ismanager) : admin.ismanager != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (loginTime != null ? loginTime.hashCode() : 0);
        result = 31 * result + (corpId != null ? corpId.hashCode() : 0);
        result = 31 * result + (ismanager != null ? ismanager.hashCode() : 0);
        return result;
    }
}
