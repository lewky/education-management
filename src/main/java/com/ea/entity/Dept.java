// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-13, Lewis.Liu created
// ============================================================================
package com.ea.entity;

import com.ea.entity.base.BaseEntity;

/**
 * @author Lewis.Liu
 */
public class Dept extends BaseEntity {

    private static final long serialVersionUID = -5146770431475764083L;

    private Long deptNo;
    private String name;
    private String schoolName;
    private Long schoolId;
    private String dean;
    private Long deanId;
    private String description;
    private String place;
    private String telephone;

    /**
     * @return the deptNo
     */
    public Long getDeptNo() {
        return deptNo;
    }

    /**
     * @param deptNo
     *            the deptNo to set
     */
    public void setDeptNo(final Long deptNo) {
        this.deptNo = deptNo;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the schoolName
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * @param schoolName
     *            the schoolName to set
     */
    public void setSchoolName(final String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * @return the schoolId
     */
    public Long getSchoolId() {
        return schoolId;
    }

    /**
     * @param schoolId
     *            the schoolId to set
     */
    public void setSchoolId(final Long schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * @return the dean
     */
    public String getDean() {
        return dean;
    }

    /**
     * @param dean
     *            the dean to set
     */
    public void setDean(final String dean) {
        this.dean = dean;
    }

    /**
     * @return the deanId
     */
    public Long getDeanId() {
        return deanId;
    }

    /**
     * @param deanId
     *            the deanId to set
     */
    public void setDeanId(final Long deanId) {
        this.deanId = deanId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place
     *            the place to set
     */
    public void setPlace(final String place) {
        this.place = place;
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

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Dept [deptNo=" + deptNo + ", name=" + name + ", schoolName=" + schoolName + ", schoolId=" + schoolId
                + ", dean=" + dean + ", deanId=" + deanId + ", description=" + description + ", place=" + place
                + ", telephone=" + telephone + ", " + super.toString() + "]";
    }
}
