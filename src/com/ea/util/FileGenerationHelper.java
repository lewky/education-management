// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-12, Lewis.Liu created
// ============================================================================
package com.ea.util;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
     * Generate header comment in java file.
     * @return
     */
    private static String genHeaderComment() {
        final Calendar calendar = Calendar.getInstance();
        final SimpleDateFormat dateFomat = new SimpleDateFormat(GenerationConsts.DEFAULT_DATE_FORMAT);
        final String projectStartDate = StringUtils.isNotBlank(PROJECT_START_DATE) ? PROJECT_START_DATE
                : calendar.get(Calendar.YEAR) + "";
        final String projectAuthor = StringUtils.isNotBlank(PROJECT_AUTHOR) ? PROJECT_AUTHOR
                : GenerationConsts.DEFAULT_AUTHOR;
        final String projectVersion = StringUtils.isNotBlank(PROJECT_VERSION) ? PROJECT_VERSION
                : GenerationConsts.DEFAULT_VERSION;

        return String.format(GenerationConsts.CODE_HEADER_COMMENT, projectStartDate, calendar.get(Calendar.YEAR),
                projectAuthor, projectVersion, dateFomat.format(calendar.getTime()));

    }

    /**
     * Generate fields in Consts or FormEntity java file.
     * @param isConsts
     * @param fields
     * @return
     */
    private static <T> String genFields(final boolean isConsts, final List<String> fieldNames) {
        final StringBuilder builder = new StringBuilder();
        for (final String fieldName : fieldNames) {
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
    private static String genMethod(final List<String> fieldNames) {
        final StringBuilder builder = new StringBuilder();
        for (final String fieldName : fieldNames) {
            builder.append(String.format(GenerationConsts.SETTER_METHOD, StringUtils.capitalize(fieldName), fieldName))
                    .append(String.format(GenerationConsts.GETTER_METHOD, StringUtils.capitalize(fieldName),
                            fieldName));
        }

        return Objects.toString(builder);
    }

    /**
     * Generate java file for entity, if isConsts is true, it will generate entity consts;
     * if isConsts is false, it will generate entity form.
     * @param clazz
     * @param isConsts
     * @return
     */
    private static <T> String genJavaFile(final Class<T> clazz, final boolean isConsts) {
        final StringBuilder builder = new StringBuilder();
        builder.append(genHeaderComment());
        final String packageName = StringUtils.substringBeforeLast(clazz.getName(), GenerationConsts.SEPARATOR_DOT);
        final String simpleName = clazz.getSimpleName();
        final Field[] fields = clazz.getDeclaredFields();
        final List<String> fieldNames = new ArrayList<String>();
        for (final Field field : fields) {
            field.setAccessible(true);
            final String fieldName = field.getName();
            if (StringUtils.equals(fieldName, GenerationConsts.FIELD_SERIAL_VERSION_UID)) {
                continue;
            }
            fieldNames.add(fieldName);
        }
        String fileBody = genFields(isConsts, fieldNames);
        if (isConsts) {
            builder.append(String.format(GenerationConsts.CODE_PACKAGE_CONSTS, packageName))
                    .append(String.format(GenerationConsts.CONSTS_FILE_TEMPLATE, simpleName, fileBody));
        } else {
            builder.append(String.format(GenerationConsts.CODE_PACKAGE_FORM, packageName))
                    .append(GenerationConsts.CODE_IMPORT_FORM);
            fileBody = Objects.toString(new StringBuilder(fileBody).append(genMethod(fieldNames)));
            builder.append(String.format(GenerationConsts.FORM_FILE_TEMPLATE, simpleName, fileBody));
        }
        return Objects.toString(builder);
    }

    /**
     * Generate entity consts file for a entity.
     * @param clazz
     */
    public static <T> void genEntityConsts(final Class<T> clazz) {
        final String projectPath = System.getProperty(GenerationConsts.KEY_USER_DIR);
        final StringBuilder builder = new StringBuilder();
        builder.append(projectPath).append(GenerationConsts.SEPARATOR_PATH).append(clazz.getName())
                .append(GenerationConsts.SUFFIX_FOR_CONSTS_PATH);
        final String targetPath = StringUtils.isNotBlank(GEN_FILE_TARGET_PATH) ? GEN_FILE_TARGET_PATH
                : Objects.toString(builder);
        final File file = new File(targetPath);
        if (!file.exists()) {
            file.mkdirs();
        }

    }
}
