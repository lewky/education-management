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
public class School extends BaseEntity {

    private static final long serialVersionUID = -7816868175234884845L;

    private Long schoolNo;
    private String name;
    private String presidentName;
    private Long presidentId;
    private String description;
    private String place;

    /**
     * @return the schoolNo
     */
    public Long getSchoolNo() {
        return schoolNo;
    }

    /**
     * @param schoolNo
     *            the schoolNo to set
     */
    public void setSchoolNo(final Long schoolNo) {
        this.schoolNo = schoolNo;
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
     * @return the president
     */
    public String getPresidentName() {
        return presidentName;
    }

    /**
     * @param president
     *            the president to set
     */
    public void setPresidentName(final String presidentName) {
        this.presidentName = presidentName;
    }

    /**
     * @return the presidentId
     */
    public Long getPresidentId() {
        return presidentId;
    }

    /**
     * @param presidentId
     *            the presidentId to set
     */
    public void setPresidentId(final Long presidentId) {
        this.presidentId = presidentId;
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

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final String baseEntityStr = super.toString();
        return "School [schoolNo=" + schoolNo + ", name=" + name + ", presidentName=" + presidentName
                + ", presidentId=" + presidentId + ", description=" + description + ", place=" + place + ", "
                + baseEntityStr + "]";
    }

}
