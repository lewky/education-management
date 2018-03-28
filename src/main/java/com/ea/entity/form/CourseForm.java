// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-25, Lewis.Liu created
// ============================================================================
package com.ea.entity.form;

import java.io.Serializable;

public class CourseForm implements Serializable {

    private static final long serialVersionUID = -6614851467800472352L;

    private String name;
    private String teacherName;
    private String teacherId;
    private String schoolYear;
    private String semester;
    private String period;
    private String credit;
    private String majorName;
    private String majorId;
    private String time;
    private String place;
    private String description;
    private String codelistBookCode;
    private String codelistBookName;
    private String courseTypeCode;
    private String courseTypeName;
    private String minor;
    private String validated;
    private String arranged;
    private String selectedNum;
    private String maxNum;

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTeacherName(final String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherId(final String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setSchoolYear(final String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSemester(final String semester) {
        this.semester = semester;
    }

    public String getSemester() {
        return semester;
    }

    public void setPeriod(final String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }

    public void setCredit(final String credit) {
        this.credit = credit;
    }

    public String getCredit() {
        return credit;
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

    public void setTime(final String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setPlace(final String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCodelistBookCode(final String codelistBookCode) {
        this.codelistBookCode = codelistBookCode;
    }

    public String getCodelistBookCode() {
        return codelistBookCode;
    }

    public void setCodelistBookName(final String codelistBookName) {
        this.codelistBookName = codelistBookName;
    }

    public String getCodelistBookName() {
        return codelistBookName;
    }

    public void setCourseTypeCode(final String courseTypeCode) {
        this.courseTypeCode = courseTypeCode;
    }

    public String getCourseTypeCode() {
        return courseTypeCode;
    }

    public void setCourseTypeName(final String courseTypeName) {
        this.courseTypeName = courseTypeName;
    }

    public String getCourseTypeName() {
        return courseTypeName;
    }

    public void setMinor(final String minor) {
        this.minor = minor;
    }

    public String getMinor() {
        return minor;
    }

    public void setValidated(final String validated) {
        this.validated = validated;
    }

    public String getValidated() {
        return validated;
    }

    public void setArranged(final String arranged) {
        this.arranged = arranged;
    }

    public String getArranged() {
        return arranged;
    }

    public void setSelectedNum(final String selectedNum) {
        this.selectedNum = selectedNum;
    }

    public String getSelectedNum() {
        return selectedNum;
    }

    public void setMaxNum(final String maxNum) {
        this.maxNum = maxNum;
    }

    public String getMaxNum() {
        return maxNum;
    }
}