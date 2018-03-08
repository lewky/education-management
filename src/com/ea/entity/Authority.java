// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-2-1, Lewis.Liu created
// ============================================================================
package com.ea.entity;

/**
 * @author Lewis.Liu
 */
public class Authority extends BaseEntity {

    private static final long serialVersionUID = 6394734060939149358L;

    /**
     * name for authority
     */
    private String name;

    /**
     * code for authority
     */
    private String code;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(final String code) {
        this.code = code;
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

    @Override
    public String toString() {
        final String baseEntityStr = super.toString();
        return "Authority [name=" + name + ", code=" + code + ", " + baseEntityStr + "]";
    }

}
