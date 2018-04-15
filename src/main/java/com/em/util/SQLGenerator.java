// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION em.1.0.0
// ============================================================================
// CHANGE LOG
// em.1.0.0 : 2018年3月19日, Lewis.Liu created
// ============================================================================
package com.em.util;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Objects;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.em.entity.base.BaseEntity;
import com.em.util.constant.GeneratorConsts;

/**
 * @author Lewis.Liu
 */
public final class SQLGenerator {

    // privatize constructor
    private SQLGenerator() {}

    /**
     * Generate insert sql for entity.
     *
     * @param clazz
     * @return
     */
    public static <T> String genInsertSQL(final Class<T> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        if (!StringUtils.equals(clazz.getName(), BaseEntity.class.getName())) {
            final Field[] commonFields = BaseEntity.class.getDeclaredFields();
            fields = ArrayUtils.addAll(fields, commonFields);
        }
        final String className = clazz.getSimpleName();
        final String fieldsStr = String.format(Locale.US, GeneratorConsts.SQL_FIELD_PARENTHESES,
                fields2String(false, fields));
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            builder.append(GeneratorConsts.SQL_PREPARED_FIELD_COMMA);
        }
        final String sqlBody = StringUtils.substringBeforeLast(Objects.toString(builder),
                GeneratorConsts.SEPARATOR_COMMA);
        return String.format(Locale.US, GeneratorConsts.SQL_INSERT_INTO_SELECT, GeneratorConsts.PREFIX_FOR_TABLE_NAME,
                NameUtils.camel2underscore(className), fieldsStr, sqlBody);
    }

    private static String fields2String(final boolean hasAlias, final Field... fields) {
        if (ArrayUtils.isEmpty(fields)) {
            return "";
        }
        final StringBuilder builder = new StringBuilder();
        for (final Field field : fields) {
            field.setAccessible(true);
            final String fieldName = field.getName();
            if (StringUtils.equals(fieldName, GeneratorConsts.FIELD_SERIAL_VERSION_UID)) {
                continue;
            }
            if (hasAlias) {
                final String alias = NameUtils.camel2underscore(fieldName);
                builder.append(String.format(Locale.US, GeneratorConsts.SQL_FIELD_AS_ALIAS, fieldName, alias));
            } else {
                builder.append(String.format(Locale.US, GeneratorConsts.SQL_FIELD_COMMA, fieldName));
            }
        }

        return StringUtils.substringBeforeLast(Objects.toString(builder), GeneratorConsts.SEPARATOR_COMMA);
    }

}
