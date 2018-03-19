// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-12, Lewis.Liu created
// ============================================================================
package com.ea.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Lewis.Liu
 */
public final class ContsGenerationHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContsGenerationHelper.class);

    static final String FIELD_SERIAL_VERSION_UID = "serialVersionUID";
    private static final String MODIFIER_CONSTS = "public static final ";
    private static final String FIELD_TYPE_STRING = "String";
    private static final String FIELD_TYPE_DATE = "Date";
    private static final String KEY_FILED_NAME = "fieldName";
    private static final String KEY_FILED_TYPE = "fieldType";
    private static final String KEY_FILED_MODIFIER = "fieldModifier";

    /**
     * 要生成的java文件是否是常量类
     */
    private boolean consts;

    public ContsGenerationHelper() {
    }

    public ContsGenerationHelper(final boolean consts) {
        this.consts = consts;
    }

    // TODO generation helper to generate Consts/FormEntity
    public Map<String, Object> parseFields(final Field... fields) {
        final Map<String, Object> result = new HashMap<String, Object>();
        for (final Field field : fields) {
            field.setAccessible(true);
            final String fieldName = field.getName();
            if (StringUtils.equals(fieldName, FIELD_SERIAL_VERSION_UID)) {
                continue;
            }
            final String fieldType = field.getType().getName();
            result.put(KEY_FILED_NAME, fieldName);
            result.put(KEY_FILED_TYPE, fieldType);
            result.put(KEY_FILED_MODIFIER, MODIFIER_CONSTS);
        }
        return result;
    }

}
