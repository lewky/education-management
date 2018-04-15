// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION em.1.0.0
// ============================================================================
// CHANGE LOG
// em.1.0.0 : 2018-3-25, Lewis.Liu created
// ============================================================================
package com.em.entity.form;

import java.io.Serializable;

public class DeptForm implements Serializable {

    private static final long serialVersionUID = 1965415405107320116L;

    private String deptNo;
    private String name;
    private String schoolName;
    private String schoolId;
    private String dean;
    private String deanId;
    private String description;
    private String place;
    private String telephone;

    public void setDeptNo(final String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSchoolName(final String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolId(final String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setDean(final String dean) {
        this.dean = dean;
    }

    public String getDean() {
        return dean;
    }

    public void setDeanId(final String deanId) {
        this.deanId = deanId;
    }

    public String getDeanId() {
        return deanId;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPlace(final String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setTelephone(final String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }
}