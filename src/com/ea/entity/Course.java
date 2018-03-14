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
public class Course extends BaseEntity {

    private static final long serialVersionUID = -1801914724961994966L;

    private String name;
    private String teacherName;
    private Long teacherId;
    private Short schoolYear;
    private Byte semester;
    private Float period;
    private Float credit;
    private String majorName;
    private Long majorId;
    private String time;
    private String place;
    private String description;
    private String codelistBookCode;
    private String codelistBookName;
    private String courseTypeCode;
    private String courseTypeName;
    private Boolean minor;
    private Boolean validated;
    private Boolean arranged;
    private Short selectedNum;
    private Short maxNum;

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
     * @return the teacherName
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @param teacherName
     *            the teacherName to set
     */
    public void setTeacherName(final String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * @return the teacherId
     */
    public Long getTeacherId() {
        return teacherId;
    }

    /**
     * @param teacherId
     *            the teacherId to set
     */
    public void setTeacherId(final Long teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * @return the schoolYear
     */
    public Short getSchoolYear() {
        return schoolYear;
    }

    /**
     * @param schoolYear
     *            the schoolYear to set
     */
    public void setSchoolYear(final Short schoolYear) {
        this.schoolYear = schoolYear;
    }

    /**
     * @return the semester
     */
    public Byte getSemester() {
        return semester;
    }

    /**
     * @param semester
     *            the semester to set
     */
    public void setSemester(final Byte semester) {
        this.semester = semester;
    }

    /**
     * @return the period
     */
    public Float getPeriod() {
        return period;
    }

    /**
     * @param period
     *            the period to set
     */
    public void setPeriod(final Float period) {
        this.period = period;
    }

    /**
     * @return the credit
     */
    public Float getCredit() {
        return credit;
    }

    /**
     * @param credit
     *            the credit to set
     */
    public void setCredit(final Float credit) {
        this.credit = credit;
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
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time
     *            the time to set
     */
    public void setTime(final String time) {
        this.time = time;
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
     * @return the codelistBookCode
     */
    public String getCodelistBookCode() {
        return codelistBookCode;
    }

    /**
     * @param codelistBookCode
     *            the codelistBookCode to set
     */
    public void setCodelistBookCode(final String codelistBookCode) {
        this.codelistBookCode = codelistBookCode;
    }

    /**
     * @return the codelistBookName
     */
    public String getCodelistBookName() {
        return codelistBookName;
    }

    /**
     * @param codelistBookName
     *            the codelistBookName to set
     */
    public void setCodelistBookName(final String codelistBookName) {
        this.codelistBookName = codelistBookName;
    }

    /**
     * @return the courseTypeCode
     */
    public String getCourseTypeCode() {
        return courseTypeCode;
    }

    /**
     * @param courseTypeCode
     *            the courseTypeCode to set
     */
    public void setCourseTypeCode(final String courseTypeCode) {
        this.courseTypeCode = courseTypeCode;
    }

    /**
     * @return the courseTypeName
     */
    public String getCourseTypeName() {
        return courseTypeName;
    }

    /**
     * @param courseTypeName
     *            the courseTypeName to set
     */
    public void setCourseTypeName(final String courseTypeName) {
        this.courseTypeName = courseTypeName;
    }

    /**
     * @return the minor
     */
    public Boolean getMinor() {
        return minor;
    }

    /**
     * @param minor
     *            the minor to set
     */
    public void setMinor(final Boolean minor) {
        this.minor = minor;
    }

    /**
     * @return the validated
     */
    public Boolean getValidated() {
        return validated;
    }

    /**
     * @param validated
     *            the validated to set
     */
    public void setValidated(final Boolean validated) {
        this.validated = validated;
    }

    /**
     * @return the arranged
     */
    public Boolean getArranged() {
        return arranged;
    }

    /**
     * @param arranged
     *            the arranged to set
     */
    public void setArranged(final Boolean arranged) {
        this.arranged = arranged;
    }

    /**
     * @return the selectedNum
     */
    public Short getSelectedNum() {
        return selectedNum;
    }

    /**
     * @param selectedNum
     *            the selectedNum to set
     */
    public void setSelectedNum(final Short selectedNum) {
        this.selectedNum = selectedNum;
    }

    /**
     * @return the maxNum
     */
    public Short getMaxNum() {
        return maxNum;
    }

    /**
     * @param maxNum
     *            the maxNum to set
     */
    public void setMaxNum(final Short maxNum) {
        this.maxNum = maxNum;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final String baseEntityStr = super.toString();
        return "Course [name=" + name + ", teacherName=" + teacherName + ", teacherId=" + teacherId + ", schoolYear="
                + schoolYear + ", semester=" + semester + ", period=" + period + ", credit=" + credit + ", majorName="
                + majorName + ", majorId=" + majorId + ", time=" + time + ", place=" + place + ", description="
                + description + ", codelistBookCode=" + codelistBookCode + ", codelistBookName=" + codelistBookName
                + ", courseTypeCode=" + courseTypeCode + ", courseTypeName=" + courseTypeName + ", minor=" + minor
                + ", validated=" + validated + ", arranged=" + arranged + ", selectedNum=" + selectedNum + ", maxNum="
                + maxNum + ", " + baseEntityStr + "]";
    }

}
