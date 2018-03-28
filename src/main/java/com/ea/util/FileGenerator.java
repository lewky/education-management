// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-12, Lewis.Liu created
// ============================================================================
package com.ea.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ea.util.constant.GeneratorConsts;

/**
 * @author Lewis.Liu
 */
public final class FileGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileGenerator.class);

    // keys in the db config properties
    private static final String KEY_GEN_FILE_SRC_PATH = "gen.file.src.path";
    private static final String KEY_GEN_FILE_TARGET_PATH = "gen.file.target.path";
    private static final String KEY_PROJECT_START_DATE = "project.start.date";
    private static final String KEY_PROJECT_AUTHOR = "project.author";
    private static final String KEY_PROJECT_VERSION = "project.version";

    /**
     * generation config file
     */
    private static final String GENERATION_CONFIG_NAME = "GeneratorConfig";

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
    private FileGenerator() {}

    /**
     * Generate header comment in java file.
     * @return
     */
    private static String genHeaderComment() {
        final Calendar calendar = Calendar.getInstance();
        final SimpleDateFormat dateFomat = new SimpleDateFormat(GeneratorConsts.DEFAULT_DATE_FORMAT);
        final String projectStartDate = StringUtils.defaultIfBlank(PROJECT_START_DATE,
                calendar.get(Calendar.YEAR) + "");
        final String projectAuthor = StringUtils.defaultIfBlank(PROJECT_AUTHOR, GeneratorConsts.DEFAULT_AUTHOR);
        final String projectVersion = StringUtils.defaultIfBlank(PROJECT_VERSION, GeneratorConsts.DEFAULT_VERSION);

        return String.format(GeneratorConsts.CODE_HEADER_COMMENT, projectStartDate, calendar.get(Calendar.YEAR),
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
            if (StringUtils.equals(fieldName, GeneratorConsts.FIELD_SERIAL_VERSION_UID)) {
                continue;
            }
            newfieldName = StringUtils.upperCase(NameUtils.camel2underscore(fieldName), Locale.US);
            if (isConsts) {
                builder.append(String.format(GeneratorConsts.FIELD_IN_CONSTS, newfieldName, fieldName));
            } else {
                builder.append(String.format(GeneratorConsts.FIELD_IN_FORM, fieldName));
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
            builder.append(String.format(GeneratorConsts.SETTER_METHOD, StringUtils.capitalize(fieldName), fieldName))
                    .append(String.format(GeneratorConsts.GETTER_METHOD, StringUtils.capitalize(fieldName), fieldName));
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
        final String packageName = getPackageName(clazz);
        final String simpleName = clazz.getSimpleName();
        final Field[] fields = clazz.getDeclaredFields();
        final List<String> fieldNames = new ArrayList<String>();
        for (final Field field : fields) {
            field.setAccessible(true);
            final String fieldName = field.getName();
            if (StringUtils.equals(fieldName, GeneratorConsts.FIELD_SERIAL_VERSION_UID)) {
                continue;
            }
            fieldNames.add(fieldName);
        }
        String fileBody = genFields(isConsts, fieldNames);
        if (isConsts) {
            builder.append(String.format(GeneratorConsts.CODE_PACKAGE_CONSTS, packageName))
                    .append(String.format(GeneratorConsts.CONSTS_FILE_TEMPLATE, simpleName, fileBody));
        } else {
            builder.append(String.format(GeneratorConsts.CODE_PACKAGE_FORM, packageName))
                    .append(GeneratorConsts.CODE_IMPORT_FORM);
            fileBody = Objects.toString(new StringBuilder(fileBody).append(genMethod(fieldNames)));
            builder.append(String.format(GeneratorConsts.FORM_FILE_TEMPLATE, simpleName, fileBody));
        }
        return Objects.toString(builder);
    }

    /**
     * Get package name of class.
     * @param clazz
     * @return
     */
    private static <T> String getPackageName(final Class<T> clazz) {
        final String packageName = StringUtils.substringBeforeLast(clazz.getName(), GeneratorConsts.SEPARATOR_DOT);
        return packageName;
    }

    /**
     * Generate entity consts/form file for a entity.
     * @param clazz
     * @param isConsts
     */
    public static <T> void genEntityFile(final Class<T> clazz, final boolean isConsts) {
        String basePath = System.getProperty(GeneratorConsts.KEY_USER_DIR);
        basePath = StringUtils.defaultIfBlank(GEN_FILE_TARGET_PATH, basePath);
        final StringBuilder pathBuilder = new StringBuilder();
        String temp = StringUtils.replace(getPackageName(clazz), GeneratorConsts.SEPARATOR_DOT,
                GeneratorConsts.SEPARATOR_PATH);
        if (isConsts) {
            temp = temp + GeneratorConsts.SUFFIX_FOR_CONSTS_PATH;
        } else {
            temp = temp + GeneratorConsts.SUFFIX_FOR_FORM_PATH;
        }
        pathBuilder.append(basePath).append(GeneratorConsts.SEPARATOR_PATH).append(temp);
        final String targetPath = Objects.toString(pathBuilder);
        final StringBuilder nameBuilder = new StringBuilder();
        if (isConsts) {
            nameBuilder.append(clazz.getSimpleName()).append(GeneratorConsts.SUFFIX_FOR_CONSTS_NAME);
        } else {
            nameBuilder.append(clazz.getSimpleName()).append(GeneratorConsts.SUFFIX_FOR_FORM_NAME);
        }
        final String fileName = Objects.toString(nameBuilder);
        final String fullPath = Objects
                .toString(new StringBuilder(targetPath).append(GeneratorConsts.SEPARATOR_PATH).append(fileName));
        final File file = new File(targetPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File(fullPath), false);
            os.write(genJavaFile(clazz, isConsts).getBytes(GeneratorConsts.UTF_8));
        } catch (final IOException e) {
            if (isConsts) {
                LOGGER.error("Failed to generate consts file for entity.", e);
            } else {
                LOGGER.error("Failed to generate form file for entity.", e);
            }
        } finally {
            IOUtils.closeQuietly(os);
        }
    }
}
