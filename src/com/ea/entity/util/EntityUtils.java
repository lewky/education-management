// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-2-2, Lewis.Liu created
// ============================================================================
package com.ea.entity.util;

import java.lang.reflect.Field;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Lewis.Liu
 */
public final class EntityUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(EntityUtils.class);

    // privatize constructor
    private EntityUtils() {
    }

    public static void genAllEntityConsts(final String srcPath) {

    }

    public static void genAllEntityConsts(final String srcPath, final String targetPath) {

    }

    public static <T> void genEntityConsts(final Class<T> clazz) {

    }

    // TODO gen entity fields consts/beanConsts...
    private static <T> Map<String, Object> getFields(final Class<T> clazz, final boolean isConsts) {
        final Field[] fields = clazz.getDeclaredFields();
        final Map<String, Object> newFields = null;
        if (fields.length <= 0) {
            return newFields;
        }

        return newFields;
    }
}
