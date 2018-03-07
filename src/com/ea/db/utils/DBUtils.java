// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-1-12, Lewis.Liu created
// ============================================================================
package com.ea.db.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * utils for db
 *
 * @author Lewis.Liu
 */
public final class DBUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBUtils.class);

    // keys in the db config properties
    private static final String KEY_DRIVER_CLASS = "driverClass";
    private static final String KEY_URL = "url";
    private static final String KEY_JDBC_USER = "jdbc.user";
    private static final String KEY_PASSWORD = "password";

    /**
     * db config file
     */
    private static final String DB_CONFIG_NAME = "dbcfg";
    /**
     * driver class for jdbc
     */
    private static final String DRIVER_CLASS;
    /**
     * url for jdbc
     */
    private static final String URL;
    /**
     * user for jdbc
     */
    private static final String JDBC_USER;
    /**
     * password for jdbc
     */
    private static final String PASSWORD;

    static {
        // get values form the db config file by the keys
        final ResourceBundle rb = ResourceBundle.getBundle(DB_CONFIG_NAME);
        DRIVER_CLASS = rb.getString(KEY_DRIVER_CLASS);
        URL = rb.getString(KEY_URL);
        JDBC_USER = rb.getString(KEY_JDBC_USER);
        PASSWORD = rb.getString(KEY_PASSWORD);

        // load jdbc driver class
        try {
            Class.forName(DRIVER_CLASS);
        } catch (final ClassNotFoundException e) {
            LOGGER.error("Failed to load jdbc driver class.", e);
        }
    }

    // privatize constructor
    private DBUtils() {
    }

    /**
     * get jdbc connection to connect db
     *
     * @return jdbc Connection
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, JDBC_USER, PASSWORD);
        } catch (final SQLException e) {
            LOGGER.error("Failed to get jdbc Connection.", e);
        }
        return conn;
    }

    /**
     * close ResultSet, Statement & Connection for jdbc
     *
     * @param rs
     *            jdbc ResultSet
     * @param st
     *            jdbc Statement
     * @param conn
     *            jdbc Connection
     */
    public static void release(final ResultSet rs, final Statement st, final Connection conn) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (final SQLException e) {
            LOGGER.error("Failed to close jdbc ResultSet.", e);
        }
        try {
            if (st != null && !st.isClosed()) {
                st.close();
            }
        } catch (final SQLException e) {
            LOGGER.error("Failed to close jdbc Statement.", e);
        }
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (final SQLException e) {
            LOGGER.error("Failed to close jdbc Connection.", e);
        }
    }
}
