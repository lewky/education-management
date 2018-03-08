// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-2-2, Lewis.Liu created
// ============================================================================
package com.ea.entity.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Lewis.Liu
 */
public final class EntityUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(EntityUtils.class);

    /**
     * prefix string for toString() method
     */
    private static final String PREFIX_FOR_STRING = " [";

    /**
     * suffix string for toString() method
     */
    private static final String SUFFIX_FOR_STRING = "]";

    /**
     * seperator for entity fields
     */
    private static final String SEPERATOR_FOR_FIELD = ", ";

    /**
     * equal sign
     */
    private static final String EQUAL_SIGN = "=";

    // privatize constructor
    private EntityUtils() {
    }

}
