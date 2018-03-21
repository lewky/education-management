// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018年3月20日, Lewis.Liu created
// ============================================================================
package com.ea.util.constant;

/**
 * @author Lewis.Liu
 */
public class GenerationConsts {

    // const variables for generating sql
    public static final String SQL_INSERT_INTO_SELECT = "insert into %1$s%2$s %3$s %n select %4$s;";
    public static final String SQL_SELECT = "select %1$s from %2$s%3$s%4$s;";
    public static final String SQL_WHERE_RESTRICTION = " where %1$s";
    public static final String SQL_RESTRICTION = "%1$s.%2$s = ? and ";
    public static final String SQL_FIELD_COMMA = "%1$s, ";
    public static final String SQL_FIELD_AS_ALIAS = "%1$s.%2$s as %3$s,%n";
    public static final String SQL_FIELD_PARENTHESES = "(%1$s)";
    public static final String SQL_PREPARED_FIELD_COMMA = "?, ";
    public static final String PREFIX_FOR_TABLE_NAME = "ea_";
    public static final String SEPARATOR_COMMA = ",";

    // const variables for generating Consts/FormEntity
    public static final String FIELD_SERIAL_VERSION_UID = "serialVersionUID";
    public static final String CODE_HEADER_COMMENT = "// Copyright (c) %1$s-%2$s %3$s Limited. All rights reserved.\r\n"
            + "// ============================================================================\r\n"
            + "// CURRENT VERSION %4$s\r\n"
            + "// ============================================================================\r\n"
            + "// CHANGE LOG\r\n" + "// %4$s : %5$s, %3$s created\r\n"
            + "// ============================================================================";
    public static final String CODE_PACKAGE = "package %1$s.constant.%2$s;%n";
    public static final String TEMPLATE_CONSTS_FILE = "public class %1$sConsts {%n%n%1$s}";
    public static final String TEMPLATE_FORM_FILE = "public class %1$sForm {%n%n%1$s}";
    public static final String FIELD_IN_CONSTS = "\tpublic static final String %1$s = \"%2$s\";%n";
    public static final String FIELD_IN_FORM = "\tprivate String %1$s;%n";
    public static final String SETTER_METHOD = "\tpublic void set%1$s(String %2$s) {%n\t\tthis.%2$s = %2$s;%n\t}%n%n";
    public static final String GETTER_METHOD = "\tpublic String get%1$s() {%n\t\treturn %2$s;%n\t}%n%n";
}
