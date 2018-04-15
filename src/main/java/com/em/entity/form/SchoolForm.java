// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION em.1.0.0
// ============================================================================
// CHANGE LOG
// em.1.0.0 : 2018-3-25, Lewis.Liu created
// ============================================================================
package com.em.entity.form;

import java.io.Serializable;

public class SchoolForm implements Serializable {

    private static final long serialVersionUID = -941994109622738606L;

    private String schoolNo;
    private String name;
    private String presidentName;
    private String presidentId;
    private String description;
    private String place;

    public void setSchoolNo(final String schoolNo) {
        this.schoolNo = schoolNo;
    }

    public String getSchoolNo() {
        return schoolNo;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPresidentName(final String presidentName) {
        this.presidentName = presidentName;
    }

    public String getPresidentName() {
        return presidentName;
    }

    public void setPresidentId(final String presidentId) {
        this.presidentId = presidentId;
    }

    public String getPresidentId() {
        return presidentId;
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
}