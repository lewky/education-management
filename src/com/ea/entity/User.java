// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-8, Lewis.Liu created
// ============================================================================
package com.ea.entity;

import java.util.Date;

/**
 * @author Lewis.Liu
 */
public class User extends BaseEntity {

    private static final long serialVersionUID = 5584646154498718275L;

    /**
     * 登陆ID/学生学号/教师工号/管理员工号
     */
    private Long loginId;
    private String password;
    /**
     * 密码盐值
     */
    private String passwordSalt;
    private String roleId;
    /**
     * 账户是否有效
     */
    private Boolean valid;
    /**
     * 角色状态
     */
    private Byte state;
    private String firstName;
    private String lastName;
    private String avator;
    private Byte gender;
    private Date birthday;
    private String email;
    private String telephone;
    private String teacherTitle;
    private Date inDate;
    private String inGrade;
    private Date outDate;
    private Date lastLogin;

    /**
     * @return the loginId
     */
    public Long getLoginId() {
        return loginId;
    }

    /**
     * @param loginId
     *            the loginId to set
     */
    public void setLoginId(final Long loginId) {
        this.loginId = loginId;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return the passwordSalt
     */
    public String getPasswordSalt() {
        return passwordSalt;
    }

    /**
     * @param passwordSalt
     *            the passwordSalt to set
     */
    public void setPasswordSalt(final String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    /**
     * @return the roleId
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     *            the roleId to set
     */
    public void setRoleId(final String roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the valid
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * @param valid
     *            the valid to set
     */
    public void setValid(final Boolean valid) {
        this.valid = valid;
    }

    /**
     * @return the state
     */
    public Byte getState() {
        return state;
    }

    /**
     * @param state
     *            the state to set
     */
    public void setState(final Byte state) {
        this.state = state;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the avator
     */
    public String getAvator() {
        return avator;
    }

    /**
     * @param avator
     *            the avator to set
     */
    public void setAvator(final String avator) {
        this.avator = avator;
    }

    /**
     * @return the gender
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * @param gender
     *            the gender to set
     */
    public void setGender(final Byte gender) {
        this.gender = gender;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     *            the birthday to set
     */
    public void setBirthday(final Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     *            the telephone to set
     */
    public void setTelephone(final String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the teacherTitle
     */
    public String getTeacherTitle() {
        return teacherTitle;
    }

    /**
     * @param teacherTitle
     *            the teacherTitle to set
     */
    public void setTeacherTitle(final String teacherTitle) {
        this.teacherTitle = teacherTitle;
    }

    /**
     * @return the inDate
     */
    public Date getInDate() {
        return inDate;
    }

    /**
     * @param inDate
     *            the inDate to set
     */
    public void setInDate(final Date inDate) {
        this.inDate = inDate;
    }

    /**
     * @return the inGrade
     */
    public String getInGrade() {
        return inGrade;
    }

    /**
     * @param inGrade
     *            the inGrade to set
     */
    public void setInGrade(final String inGrade) {
        this.inGrade = inGrade;
    }

    /**
     * @return the outDate
     */
    public Date getOutDate() {
        return outDate;
    }

    /**
     * @param outDate
     *            the outDate to set
     */
    public void setOutDate(final Date outDate) {
        this.outDate = outDate;
    }

    /**
     * @return the lastLogin
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * @param lastLogin
     *            the lastLogin to set
     */
    public void setLastLogin(final Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "User [loginId=" + loginId + ", password=" + password + ", passwordSalt=" + passwordSalt + ", roleId="
                + roleId + ", valid=" + valid + ", state=" + state + ", firstName=" + firstName + ", lastName="
                + lastName + ", avator=" + avator + ", gender=" + gender + ", birthday=" + birthday + ", email="
                + email + ", telephone=" + telephone + ", teacherTitle=" + teacherTitle + ", inDate=" + inDate
                + ", inGrade=" + inGrade + ", outDate=" + outDate + ", lastLogin=" + lastLogin + ", "
                + super.toString() + "]";
    }

}
