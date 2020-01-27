package com.mycomp.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mycomp.jdbc.handler.IResultSetHandler;

public class CRUDTemplate {

    public static int executeUpdate(String sql, Object... params) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                statement.setObject((i + 1), params[i]);
            }
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, null);
        }
        return -1;
    }

    public static <T>T executeQuery(String sql,
            IResultSetHandler<T> resultSetHandler, Object... params) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                statement.setObject((i + 1), params[i]);
            }
            rs = statement.executeQuery();
            return resultSetHandler.handle(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, rs);
        }
        return null;
    }

}
