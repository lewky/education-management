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
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ea.util.constant.GenerationConsts;

/**
 * @author Lewis.Liu
 */
public final class FileGenerationHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileGenerationHelper.class);

    // keys in the db config properties
    private static final String KEY_GEN_FILE_SRC_PATH = "gen.file.src.path";
    private static final String KEY_GEN_FILE_TARGET_PATH = "gen.file.target.path";
    private static final String KEY_PROJECT_START_DATE = "project.start.date";
    private static final String KEY_PROJECT_AUTHOR = "project.author";
    private static final String KEY_PROJECT_VERSION = "project.version";

    /**
     * generation config file
     */
    private static final String GENERATION_CONFIG_NAME = "GenerationConfig";

    // keys in generation config file
    private static final String GEN_FILE_SRC_PATH;
    private static final String GEN_FILE_TARGET_PATH;
    private static final String PROJECT_START_DATE;
    private static final String PROJECT_AUTHOR;
    private static final String PROJECT_VERSION;

    static {
        // get values form the generation config file by the keys
        final ResourceBundle resourceBundle = ResourceBundle.getBundle(GENERATION_CONFIG_NAME);
        GEN_FILE_SRC_PATH = resourceBundle.getString(KEY_GEN_FILE_SRC_PATH);
        GEN_FILE_TARGET_PATH = resourceBundle.getString(KEY_GEN_FILE_TARGET_PATH);
        PROJECT_START_DATE = resourceBundle.getString(KEY_PROJECT_START_DATE);
        PROJECT_AUTHOR = resourceBundle.getString(KEY_PROJECT_AUTHOR);
        PROJECT_VERSION = resourceBundle.getString(KEY_PROJECT_VERSION);
    }

    // privatize constructor
    private FileGenerationHelper() {
    }

    /**
     * Generate fields in Consts or FormEntity java file.
     * @param clazz
     * @param isConsts
     * @return
     */
    public static <T> String genFields(final Class<T> clazz, final boolean isConsts) {
        final Field[] fields = clazz.getDeclaredFields();
        final StringBuilder builder = new StringBuilder();
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
                builder.append(String.format(GenerationConsts.FIELD_IN_FORM, fieldName));
            }
        }
        return Objects.toString(builder);
    }

    /**
     * Generate setter/getter method in FormEntity java file.
     * @param fields
     * @return
     */
    public static String genMethod(final Field... fields) {
        final StringBuilder builder = new StringBuilder();
        for (final Field field : fields) {
            field.setAccessible(true);
            final String fieldName = field.getName();
            builder.append(String.format(GenerationConsts.SETTER_METHOD, StringUtils.capitalize(fieldName), fieldName))
                    .append(String.format(GenerationConsts.GETTER_METHOD, StringUtils.capitalize(fieldName),
                            fieldName));
        }

        return Objects.toString(builder);
    }

    // TODO : gen java files
    public static <T> String genJavaFiles(final Class<T> clazz, final boolean isConsts) {
        final StringBuilder builder = new StringBuilder();
        if (isConsts) {

        } else {

        }
        return Objects.toString(builder);
    }
}
