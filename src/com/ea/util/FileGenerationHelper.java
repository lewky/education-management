// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-12, Lewis.Liu created
// ============================================================================
package com.ea.util;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Objects;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ea.entity.BaseEntity;
import com.ea.util.constant.GenerationConsts;

/**
 * @author Lewis.Liu
 */
public final class FileGenerationHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileGenerationHelper.class);

    public FileGenerationHelper() {
    }

    // TODO Generate fields in Consts or FormEntity java file.
    public <T> String genFields(final Class<T> clazz, final boolean isConsts) {
        Field[] fields = clazz.getDeclaredFields();
        final StringBuilder builder = new StringBuilder();
        if (!StringUtils.equals(clazz.getName(), BaseEntity.class.getName())) {
            final Field[] commonFields = BaseEntity.class.getDeclaredFields();
            fields = ArrayUtils.addAll(fields, commonFields);
        }
        for (final Field field : fields) {
            field.setAccessible(true);
            final String fieldName = field.getName();
            String newfieldName = "";
            if (StringUtils.equals(fieldName, GenerationConsts.FIELD_SERIAL_VERSION_UID)) {
                continue;
            }
            newfieldName = StringUtils.upperCase(NameUtils.camel2underscore(fieldName), Locale.US);
            if (isConsts) {
                builder.append(String.format(GenerationConsts.FIELD_IN_CONSTS, newfieldName, fieldName));
            } else {
                builder.append(String.format(GenerationConsts.FIELD_IN_FORM, newfieldName, fieldName));
            }
        }
        return Objects.toString(builder);
    }

}
