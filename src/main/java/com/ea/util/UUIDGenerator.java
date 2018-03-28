// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018年3月26日, Lewis.Liu created
// ============================================================================
package com.ea.util;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.ea.util.constant.GeneratorConsts;

/**
 * @author Lewis.Liu
 *
 */
public final class UUIDGenerator {

    /**
     * Get a UUID string without dash(-).
     * @return
     */
    public static String getUUID() {
        return StringUtils.replace(UUID.randomUUID().toString(), GeneratorConsts.SIGN_DASH, StringUtils.EMPTY);
    }
}
