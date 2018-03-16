// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-1-12, Lewis.Liu created
// ============================================================================
package com.ea.db.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
     * Get jdbc connection to connect db.
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
     * Close ResultSet, Statement & Connection for jdbc.
     * <P>
     * This method is null-safe, if ResultSet, Statement & Connection is null, them will not be close.
     *
     * @param rs
     *            jdbc ResultSet
     * @param st
     *            jdbc Statement
     * @param conn
     *            jdbc Connection
     */
    public static void release(final ResultSet rs, final Statement st, final Connection conn) {
        releaseResultSet(rs);
        release(st, conn);
    }

    /**
     * Close Statement & Connection for jdbc.
     * <P>
     * This method is null-safe, if Statement & Connection is null, them will not be close.
     *
     * @param st
     * @param conn
     */
    public static void release(final Statement st, final Connection conn) {
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

    /**
     * Close ResultSet.
     * <P>
     * This method is null-safe, if ResultSet is null, it will not be close.
     *
     * @param rs
     */
    public static void releaseResultSet(final ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (final SQLException e) {
            LOGGER.error("Failed to close jdbc ResultSet.", e);
        }
    }

    public static <T> List<T> executeQuery(final Class<T> clazz, final String sql, final Object... params) {
        final Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<T> list = null;
        try {
            pstmt = conn.prepareStatement(sql);
            if (params.length != 0) {
                int i = 1;
                for (final Object param : params) {
                    pstmt.setObject(i, param);
                    i++;
                }
            }
            rs = pstmt.executeQuery();
            if (rs.next()) {
                list = new ArrayList<T>();
                while (rs.next()) {
                    try {
                        final T t = clazz.newInstance();
                        final Field[] fields = clazz.getDeclaredFields();
                        for (final Field field : fields) {
                            field.setAccessible(true);
                            final Object value = rs.getObject(field.getName(), field.getType());
                            field.set(t, value);
                        }
                        list.add(t);
                    } catch (InstantiationException | IllegalAccessException e) {
                        LOGGER.error("Failed to execute the query sql.", e);
                    }
                }
            }
        } catch (final SQLException e) {
            LOGGER.error("Failed to execute the query sql.", e);
        } finally {
            release(rs, pstmt, conn);
        }

        return list;
    }

    public static <T> boolean executeUpdate(final Class<T> t, final String sql, final Object... params) {
        final Connection conn = getConnection();
        PreparedStatement pstmt = null;
        int n = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            if (params.length != 0) {
                int i = 1;
                for (final Object param : params) {
                    pstmt.setObject(i, param);
                    i++;
                }
            }
            n = pstmt.executeUpdate();
        } catch (final SQLException e) {
            LOGGER.error("Failed to execute the query sql.", e);
        } finally {
            release(pstmt, conn);
        }

        return false;
    }
}
