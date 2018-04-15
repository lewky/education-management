// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION em.1.0.0
// ============================================================================
// CHANGE LOG
// em.1.0.0 : 2018年3月20日, Lewis.Liu created
// ============================================================================
package com.em.util.constant;

/**
 * @author Lewis.Liu
 */
public class GeneratorConsts {

    // const variables for generating sql
    public static final String SQL_INSERT_INTO_SELECT = "insert into %1$s%2$s %3$s \n select %4$s;";
    public static final String SQL_SELECT = "select %1$s from %2$s%3$s%4$s;";
    public static final String SQL_WHERE_RESTRICTION = " where %1$s";
    public static final String SQL_RESTRICTION = "%1$s.%2$s = ? and ";
    public static final String SQL_FIELD_COMMA = "%1$s, ";
    public static final String SQL_FIELD_AS_ALIAS = "%1$s.%2$s as %3$s,\n";
    public static final String SQL_FIELD_PARENTHESES = "(%1$s)";
    public static final String SQL_PREPARED_FIELD_COMMA = "?, ";
    public static final String PREFIX_FOR_TABLE_NAME = "ea_";
    public static final String SEPARATOR_COMMA = ",";

    // const variables for generating Consts/FormEntity
    public static final String FIELD_SERIAL_VERSION_UID = "serialVersionUID";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-M-d";
    public static final String DEFAULT_AUTHOR = "Anonymous Coder";
    public static final String DEFAULT_VERSION = "1.0.0";
    public static final String CODE_HemDER_COMMENT = "// Copyright (c) %1$s-%2$s %3$s Limited. All rights reserved.\r\n"
            + "// ============================================================================\r\n"
            + "// CURRENT VERSION %4$s\r\n"
            + "// ============================================================================\r\n"
            + "// CHANGE LOG\r\n" + "// %4$s : %5$s, %3$s created\r\n"
            + "// ============================================================================\r\n";
    public static final String CODE_PACKAGE_CONSTS = "package %1$s.constant;\n";
    public static final String CODE_PACKAGE_FORM = "package %1$s.form;\n";
    public static final String CODE_IMPORT_FORM = "\nimport java.io.Serializable;\n";
    public static final String SEPARATOR_DOT = ".";
    public static final String CONSTS_FILE_TEMPLATE = "\npublic class %1$sConsts {\n\n%2$s\n\tprivate %1$sConsts() {}\n}";
    public static final String FORM_FILE_TEMPLATE = "\npublic class %1$sForm implements Serializable {\n\n%2$s}";
    public static final String FIELD_IN_CONSTS = "\tpublic static final String %1$s = \"%2$s\";\n";
    public static final String FIELD_IN_FORM = "\tprivate String %1$s;\n";
    public static final String SETTER_METHOD = "\n\tpublic void set%1$s(String %2$s) {\n\t\tthis.%2$s = %2$s;\n\t}\n";
    public static final String GETTER_METHOD = "\n\tpublic String get%1$s() {\n\t\treturn %2$s;\n\t}\n";

    // key to get the absolute path of project
    public static final String KEY_USER_DIR = "user.dir";

    public static final String SEPARATOR_PATH = "\\";
    public static final String SUFFIX_FOR_CONSTS_PATH = "\\constant";
    public static final String SUFFIX_FOR_FORM_PATH = "\\form";
    public static final String SUFFIX_FOR_CONSTS_NAME = "Consts.java";
    public static final String SUFFIX_FOR_FORM_NAME = "Form.java";
    public static final String UTF_8 = "UTF-8";

    public static final String SIGN_DASH = "-";

}
