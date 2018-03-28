// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-25, Lewis.Liu created
// ============================================================================
package com.ea.entity.form;

import java.io.Serializable;

public class RoleForm implements Serializable {

    private static final long serialVersionUID = 5726464339435572401L;

    private String name;
    private String valid;

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValid(final String valid) {
        this.valid = valid;
    }

    public String getValid() {
        return valid;
    }
}