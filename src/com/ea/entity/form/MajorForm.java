// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-25, Lewis.Liu created
// ============================================================================
package com.ea.entity.form;

import java.io.Serializable;

public class MajorForm implements Serializable {

    private static final long serialVersionUID = 2385792716841093481L;

    private String majorNo;
    private String name;
    private String deptName;
    private String deptId;
    private String assistant;
    private String assistantId;
    private String telephone;
    private String description;

    public void setMajorNo(final String majorNo) {
        this.majorNo = majorNo;
    }

    public String getMajorNo() {
        return majorNo;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDeptName(final String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptId(final String deptId) {
        this.deptId = deptId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setAssistant(final String assistant) {
        this.assistant = assistant;
    }

    public String getAssistant() {
        return assistant;
    }

    public void setAssistantId(final String assistantId) {
        this.assistantId = assistantId;
    }

    public String getAssistantId() {
        return assistantId;
    }

    public void setTelephone(final String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}