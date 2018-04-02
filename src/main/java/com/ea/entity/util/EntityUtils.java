// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-2-2, Lewis.Liu created
// ============================================================================
package com.ea.entity.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ea.util.FileGenerator;

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
        FileGenerator.genFile4Entity(clazz, true);
    }

    /**
     * Generate form files for entity.
     * @param clazz
     */
    public static <T> void genEntityForm(final Class<T> clazz) {
        FileGenerator.genFile4Entity(clazz, false);
    }

    /**
     * Generate consts & form files for entity.
     * @param clazz
     */
    public static <T> void genFiles4Entity(final Class<T> clazz) {
        genEntityConsts(clazz);
        genEntityForm(clazz);
    }

}
