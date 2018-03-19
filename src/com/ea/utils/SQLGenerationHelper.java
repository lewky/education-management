// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018年3月19日, Lewis.Liu created
// ============================================================================
package com.ea.utils;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Objects;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ea.entity.BaseEntity;

/**
 * @author Lewis.Liu
 */
public class SQLGenerationHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(SQLGenerationHelper.class);

    // const variables for generating sql
    private static final String SQL_INSERT_INTO_SELECT = "insert into %1$s%2$s %3$s %n select %4$s;";
    private static final String SQL_SELECT = "select %1$s from %2$s%3$s%4$s;";
    private static final String SQL_WHERE_RESTRICTION = " where %1$s";
    private static final String SQL_RESTRICTION = "%1$s.%2$s = ? and ";
    private static final String SQL_FIELD_COMMA = "%1$s, ";
    private static final String SQL_FIELD_AS_ALIAS = "%1$s.%2$s as %3$s,%n";
    private static final String SQL_FIELD_PARENTHESES = "(%1$s)";
    private static final String SQL_PREPARED_FIELD_COMMA = "?, ";
    private static final String PREFIX_FOR_TABLE_NAME = "ea_";
    private static final String SEPARATOR_COMMA = ",";

    /**
     * Generate insert sql for entity.
     *
     * @param clazz
     * @return
     */
    public <T> String genInsertSQL(final Class<T> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        if (!StringUtils.equals(clazz.getName(), BaseEntity.class.getName())) {
            final Field[] commonFields = BaseEntity.class.getDeclaredFields();
            fields = ArrayUtils.addAll(fields, commonFields);
        }
        final String className = clazz.getSimpleName();
        final String fieldsStr = String.format(Locale.US, SQL_FIELD_PARENTHESES, fields2String(false, fields));
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            builder.append(SQL_PREPARED_FIELD_COMMA);
        }
        final String sqlBody = StringUtils.substringBeforeLast(Objects.toString(builder), SEPARATOR_COMMA);
        return String.format(Locale.US, SQL_INSERT_INTO_SELECT, PREFIX_FOR_TABLE_NAME,
                NameUtils.camel2underscore(className), fieldsStr, sqlBody);
    }

    private String fields2String(final boolean hasAlias, final Field... fields) {
        if (ArrayUtils.isEmpty(fields)) {
            return "";
        }
        final StringBuilder builder = new StringBuilder();
        for (final Field field : fields) {
            field.setAccessible(true);
            final String fieldName = field.getName();
            if (StringUtils.equals(fieldName, ContsGenerationHelper.FIELD_SERIAL_VERSION_UID)) {
                continue;
            }
            if (hasAlias) {
                final String alias = NameUtils.camel2underscore(fieldName);
                builder.append(String.format(Locale.US, SQL_FIELD_AS_ALIAS, fieldName, alias));
            } else {
                builder.append(String.format(Locale.US, SQL_FIELD_COMMA, fieldName));
            }
        }

        return StringUtils.substringBeforeLast(Objects.toString(builder), SEPARATOR_COMMA);
    }

}