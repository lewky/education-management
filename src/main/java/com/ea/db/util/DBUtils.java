// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-1-12, Lewis.Liu created
// ============================================================================
package com.ea.db.util;

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

import org.apache.commons.lang3.ArrayUtils;
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
    private static final String DB_CONFIG_NAME = "DBConfig";
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
        final ResourceBundle resourceBundle = ResourceBundle.getBundle(DB_CONFIG_NAME);
        DRIVER_CLASS = resourceBundle.getString(KEY_DRIVER_CLASS);
        URL = resourceBundle.getString(KEY_URL);
        JDBC_USER = resourceBundle.getString(KEY_JDBC_USER);
        PASSWORD = resourceBundle.getString(KEY_PASSWORD);

        // load jdbc driver class
        try {
            Class.forName(DRIVER_CLASS);
        } catch (final ClassNotFoundException e) {
            LOGGER.error("Failed to load jdbc driver class.", e);
        }
    }

    // privatize constructor
    private DBUtils() {}

    /**
     * Get jdbc connection to connect db.
     *
     * @return jdbc Connection
     */
    private static Connection getConnection() {
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
     * This method is null-safe, the null parameter will not be close.
     *
     * @param resultSet
     * @param stmt
     * @param conn
     */
    private static void release(final ResultSet resultSet, final Statement stmt, final Connection conn) {
        releaseResultSet(resultSet);
        release(stmt, conn);
    }

    /**
     * Close Statement & Connection for jdbc.
     * <P>
     * This method is null-safe, the null parameter will not be close.
     *
     * @param stmt
     * @param conn
     */
    private static void release(final Statement stmt, final Connection conn) {
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
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
     * This method is null-safe, the null parameter will not be close.
     *
     * @param resultSet
     */
    private static void releaseResultSet(final ResultSet resultSet) {
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
            }
        } catch (final SQLException e) {
            LOGGER.error("Failed to close jdbc ResultSet.", e);
        }
    }

    /**
     * Execute query prepared sql.
     *
     * @param clazz
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public static <T> List<T> executeQuery(final String sql, final Class<T> clazz, final Object... params) {
        final Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        List<T> list = null;
        try {
            pstmt = conn.prepareStatement(sql);
            if (ArrayUtils.isNotEmpty(params)) {
                int index = 1;
                for (final Object param : params) {
                    pstmt.setObject(index, param);
                    index++;
                }
            }
            resultSet = pstmt.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            list = new ArrayList<T>();
            while (resultSet.next()) {
                try {
                    final T t = clazz.newInstance();
                    final Field[] fields = clazz.getDeclaredFields();
                    for (final Field field : fields) {
                        field.setAccessible(true);
                        final Object value = resultSet.getObject(field.getName(), field.getType());
                        field.set(t, value);
                    }
                    list.add(t);
                } catch (InstantiationException | IllegalAccessException e) {
                    LOGGER.error("Failed to execute the query sql.", e);
                }
            }
        } catch (final SQLException e) {
            LOGGER.error("Failed to execute the query sql.", e);
        } finally {
            release(resultSet, pstmt, conn);
        }

        return list;
    }

    /**
     * Execute update/delete prepared sql.
     *
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public static <T> boolean executeUpdate(final String sql, final Object... params) {
        final Connection conn = getConnection();
        PreparedStatement pstmt = null;
        int num = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            if (ArrayUtils.isNotEmpty(params)) {
                int index = 1;
                for (final Object param : params) {
                    pstmt.setObject(index, param);
                    index++;
                }
            }
            num = pstmt.executeUpdate();
        } catch (final SQLException e) {
            LOGGER.error("Failed to execute the update/delete sql.", e);
        } finally {
            release(pstmt, conn);
        }

        return num > 0 ? true : false;
    }

    /**
     * Execute insert prepared sql.
     * @param sql
     * @param t
     * @param obj
     * @return
     */
    public static <T> boolean executeInsert(final String sql, final T t, final Object obj) {
        final Connection conn = getConnection();
        PreparedStatement pstmt = null;
        int num = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            if (t != null) {
                int index = 1;
                final Field[] fields = t.getClass().getDeclaredFields();
                for (final Field field : fields) {
                    field.setAccessible(true);
                    try {
                        pstmt.setObject(index, field.get(obj));
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        LOGGER.error("Failed to execute the insert sql.", e);
                    }
                    index++;
                }
            }
            num = pstmt.executeUpdate();
        } catch (final SQLException e) {
            LOGGER.error("Failed to execute the insert sql.", e);
        }

        return num > 0 ? true : false;
    }
}
