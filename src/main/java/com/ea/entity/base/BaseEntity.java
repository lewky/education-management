// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-2-1, Lewis.Liu created
// ============================================================================
package com.ea.entity.base;

import java.io.Serializable;
import java.util.Date;

/**
 * Define common fields for all entities
 *
 * @author Lewis.Liu
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 5647613333522643572L;

    /**
     * Id for every entity
     */
    private Long id;

    /**
     * When is the entity created on
     */
    private Date createdOn;

    /**
     * When is the entity updated on
     */
    private Date updatedOn;

    /**
     * Who updated the entity
     */
    private String updatedBy;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the createdOn
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * @param createdOn
     *            the createdOn to set
     */
    public void setCreatedOn(final Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * @return the updatedOn
     */
    public Date getUpdatedOn() {
        return updatedOn;
    }

    /**
     * @param updatedOn
     *            the updatedOn to set
     */
    public void setUpdatedOn(final Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    /**
     * @return the updatedBy
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy
     *            the updatedBy to set
     */
    public void setUpdatedBy(final String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "id=" + id + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", updatedBy=" + updatedBy;
    }

}
