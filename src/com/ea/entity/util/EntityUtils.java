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

import com.ea.util.FileGenerationHelper;

/**
 * @author Lewis.Liu
 */
public final class EntityUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(EntityUtils.class);

    // privatize constructor
    private EntityUtils() {}

    public static void genAllEntityConsts(final String srcPath) {

    }

    public static void genAllEntityConsts(final String srcPath, final String targetPath) {

    }

    /**
     * Generate consts file for entity.
     * @param clazz
     */
    public static <T> void genEntityConsts(final Class<T> clazz) {
        FileGenerationHelper.genEntityFile(clazz, true);
    }

    /**
     * Generate form files for entity.
     * @param clazz
     */
    public static <T> void genEntityForm(final Class<T> clazz) {
        FileGenerationHelper.genEntityFile(clazz, false);
    }

    /**
     * Generate consts & form files for entity.
     * @param clazz
     */
    public static <T> void genFiles4Entity(final Class<T> clazz) {
        genEntityConsts(clazz);
        genEntityForm(clazz);
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
