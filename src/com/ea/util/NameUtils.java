// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-17, Lewis.Liu created
// ============================================================================
package com.ea.util;

import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Lewis.Liu
 */
public final class NameUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(NameUtils.class);

    private static final String REGEX_CAMEL_CASE = "[a-z][A-Z]";
    private static final String REGEX_UNDERSCORE_CASE = "_[a-zA-Z]";
    private static final String SEPARATOR_UNDERSCORE = "_";

    // privatize constructor
    private NameUtils() {
    }

    /**
     * Change the camelCase to underscoreCase.
     * <P>
     * DemoOne -> demo_one
     * <p>
     * null -> ""
     * 
     * @param str
     * @return
     */
    public static String camel2underscore(final String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        final Pattern pattern = Pattern.compile(REGEX_CAMEL_CASE);
        final Matcher matcher = pattern.matcher(str);
        String target = null;
        String temp = null;
        String result = str;
        final StringBuilder builder = new StringBuilder();
        while (matcher.find()) {
            target = matcher.group();
            temp = builder.append(StringUtils.substring(target, 0, 1)).append(SEPARATOR_UNDERSCORE)
                    .append(StringUtils.substring(target, 1, 2)).toString();
            result = StringUtils.replace(result, target, temp);
        }
        return StringUtils.lowerCase(result, Locale.US);
    }

    /**
     * Change the underscoreCase to camelCase.
     * <P>
     * demo_one -> DemoOne
     * <p>
     * null -> ""
     * 
     * @param str
     * @return
     */
    public static String underscore2camel(final String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        final Pattern pattern = Pattern.compile(REGEX_UNDERSCORE_CASE);
        final Matcher matcher = pattern.matcher(str);
        String target = null;
        String temp = null;
        String result = str;
        while (matcher.find()) {
            target = matcher.group();
            temp = StringUtils.substring(target, 1);
            temp = StringUtils.upperCase(temp, Locale.US);
            result = StringUtils.replace(result, target, temp);
        }
        return StringUtils.capitalize(result);
    }

    /**
     * Abbreviate the input string for db table name.
     * <p>
     * null -> ""
     * <p>
     * ea_class_student -> ecs
     * 
     * @param str
     * @return
     */
    public static String abbreviateName(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        final Pattern pattern = Pattern.compile(REGEX_UNDERSCORE_CASE);
        final Matcher matcher = pattern.matcher(str);
        String target = null;
        String temp = null;
        String result = str;
        final StringBuilder builder = new StringBuilder();
        builder.append(StringUtils.substring(result, 0, 1));
        while (matcher.find()) {
            target = matcher.group();
            temp = StringUtils.substring(target, 1);
            builder.append(temp);
        }
        result = Objects.toString(builder);
        return StringUtils.lowerCase(result, Locale.US);
    }
}
