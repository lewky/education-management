// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-17, Lewis.Liu created
// ============================================================================
package com.ea.form.entity.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Lewis.Liu
 */
public final class FormEntityUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormEntityUtils.class);

    // privatize constructor
    private FormEntityUtils() {
    }

    public static <T> T fillFormEntity(final Class<T> clazz, final Map<String, String[]> properties) {
        T t = null;
        try {
            t = clazz.newInstance();
            BeanUtils.populate(t, properties);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            LOGGER.error("Failed to fill form entity.", e);
        }
        return t;
    }
}