// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION em.1.0.0
// ============================================================================
// CHANGE LOG
// em.1.0.0 : 2018-3-25, Lewis.Liu created
// ============================================================================
package com.em.entity.form;

import java.io.Serializable;

public class AuthorityForm implements Serializable {

    private static final long serialVersionUID = -2677142067995958354L;

    private String name;
    private String code;

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}