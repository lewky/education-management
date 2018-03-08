// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-8, Lewis.Liu created
// ============================================================================
package com.ea.entity;

/**
 * @author Lewis.Liu
 */
public class Role extends BaseEntity {

    private static final long serialVersionUID = -5909572565683827536L;

    /**
     * name for authority
     */
    private String name;

    /**
     * indicate whether the role is valid
     */
    private Boolean valid;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(final Boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        final String baseEntityStr = super.toString();
        return "Role [name=" + name + ", valid=" + valid + ", " + baseEntityStr + "]";
    }
}
