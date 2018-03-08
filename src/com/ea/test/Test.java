// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-7, Lewis.Liu created
// ============================================================================
package com.ea.test;

import com.ea.entity.Authority;
import com.ea.entity.BaseEntity;

/**
 * @author Lewis.Liu
 */
public class Test {

    public static void main(final String[] args) throws IllegalArgumentException, IllegalAccessException {
        final BaseEntity baseEntity = new Authority();
        System.out.println(baseEntity);
    }
}
