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
public class Major extends BaseEntity {

    private static final long serialVersionUID = -5024633542558471650L;

    private Long majorNo;
    private String name;
    private String deptName;
    private Long deptId;
    private String assistant;
    private Long assistantId;
    private String telephone;
    private String description;

    /**
     * @return the majorNo
     */
    public Long getMajorNo() {
        return majorNo;
    }

    /**
     * @param majorNo
     *            the majorNo to set
     */
    public void setMajorNo(final Long majorNo) {
        this.majorNo = majorNo;
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
     * @return the deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName
     *            the deptName to set
     */
    public void setDeptName(final String deptName) {
        this.deptName = deptName;
    }

    /**
     * @return the deptId
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * @param deptId
     *            the deptId to set
     */
    public void setDeptId(final Long deptId) {
        this.deptId = deptId;
    }

    /**
     * @return the assistant
     */
    public String getAssistant() {
        return assistant;
    }

    /**
     * @param assistant
     *            the assistant to set
     */
    public void setAssistant(final String assistant) {
        this.assistant = assistant;
    }

    /**
     * @return the assistantId
     */
    public Long getAssistantId() {
        return assistantId;
    }

    /**
     * @param assistantId
     *            the assistantId to set
     */
    public void setAssistantId(final Long assistantId) {
        this.assistantId = assistantId;
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

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Major [majorNo=" + majorNo + ", name=" + name + ", deptName=" + deptName + ", deptId=" + deptId
                + ", assistant=" + assistant + ", assistantId=" + assistantId + ", telephone=" + telephone
                + ", description=" + description + ", " + super.toString() + "]";
    }

}
