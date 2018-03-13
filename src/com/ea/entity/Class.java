// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-13, Lewis.Liu created
// ============================================================================
package com.ea.entity;

/**
 * @author Lewis.Liu
 */
public class Class extends BaseEntity {

    private static final long serialVersionUID = 9120765332083821844L;

    private Integer num;
    private Long classNo;
    private Integer grade;
    private String majorName;
    private Long majorId;
    private String classAdviser;
    private Long adviserId;

    /**
     * @return the num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * @param num
     *            the num to set
     */
    public void setNum(final Integer num) {
        this.num = num;
    }

    /**
     * @return the classNo
     */
    public Long getClassNo() {
        return classNo;
    }

    /**
     * @param classNo
     *            the classNo to set
     */
    public void setClassNo(final Long classNo) {
        this.classNo = classNo;
    }

    /**
     * @return the grade
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * @param grade
     *            the grade to set
     */
    public void setGrade(final Integer grade) {
        this.grade = grade;
    }

    /**
     * @return the majorName
     */
    public String getMajorName() {
        return majorName;
    }

    /**
     * @param majorName
     *            the majorName to set
     */
    public void setMajorName(final String majorName) {
        this.majorName = majorName;
    }

    /**
     * @return the majorId
     */
    public Long getMajorId() {
        return majorId;
    }

    /**
     * @param majorId
     *            the majorId to set
     */
    public void setMajorId(final Long majorId) {
        this.majorId = majorId;
    }

    /**
     * @return the classAdviser
     */
    public String getClassAdviser() {
        return classAdviser;
    }

    /**
     * @param classAdviser
     *            the classAdviser to set
     */
    public void setClassAdviser(final String classAdviser) {
        this.classAdviser = classAdviser;
    }

    /**
     * @return the adviserId
     */
    public Long getAdviserId() {
        return adviserId;
    }

    /**
     * @param adviserId
     *            the adviserId to set
     */
    public void setAdviserId(final Long adviserId) {
        this.adviserId = adviserId;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final String baseEntityStr = super.toString();
        return "Class [num=" + num + ", classNo=" + classNo + ", grade=" + grade + ", majorName=" + majorName
                + ", majorId=" + majorId + ", classAdviser=" + classAdviser + ", adviserId=" + adviserId + ", "
                + baseEntityStr + "]";
    }

}
