// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION em.1.0.0
// ============================================================================
// CHANGE LOG
// em.1.0.0 : 2018-3-25, Lewis.Liu created
// ============================================================================
package com.em.entity.form;

import java.io.Serializable;

public class UserForm implements Serializable {

    private static final long serialVersionUID = 6649839082563426708L;

    private String loginId;
    private String password;
    private String passwordSalt;
    private String roleId;
    private String valid;
    private String state;
    private String firstName;
    private String lastName;
    private String avator;
    private String gender;
    private String birthday;
    private String email;
    private String telephone;
    private String teacherTitle;
    private String inDate;
    private String inGrade;
    private String outDate;
    private String lastLogin;

    public void setLoginId(final String loginId) {
        this.loginId = loginId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPasswordSalt(final String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setRoleId(final String roleId) {
        this.roleId = roleId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setValid(final String valid) {
        this.valid = valid;
    }

    public String getValid() {
        return valid;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAvator(final String avator) {
        this.avator = avator;
    }

    public String getAvator() {
        return avator;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setBirthday(final String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTelephone(final String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTeacherTitle(final String teacherTitle) {
        this.teacherTitle = teacherTitle;
    }

    public String getTeacherTitle() {
        return teacherTitle;
    }

    public void setInDate(final String inDate) {
        this.inDate = inDate;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInGrade(final String inGrade) {
        this.inGrade = inGrade;
    }

    public String getInGrade() {
        return inGrade;
    }

    public void setOutDate(final String outDate) {
        this.outDate = outDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setLastLogin(final String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getLastLogin() {
        return lastLogin;
    }
}