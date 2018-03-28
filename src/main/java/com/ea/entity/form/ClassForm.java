// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-25, Lewis.Liu created
// ============================================================================
package com.ea.entity.form;

import java.io.Serializable;

public class ClassForm implements Serializable {

    private static final long serialVersionUID = -6206831454051261019L;

    private String num;
    private String classNo;
    private String grade;
    private String majorName;
    private String majorId;
    private String classAdviser;
    private String adviserId;

    public void setNum(final String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public void setClassNo(final String classNo) {
        this.classNo = classNo;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setGrade(final String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setMajorName(final String majorName) {
        this.majorName = majorName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorId(final String majorId) {
        this.majorId = majorId;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setClassAdviser(final String classAdviser) {
        this.classAdviser = classAdviser;
    }

    public String getClassAdviser() {
        return classAdviser;
    }

    public void setAdviserId(final String adviserId) {
        this.adviserId = adviserId;
    }

    public String getAdviserId() {
        return adviserId;
    }
}