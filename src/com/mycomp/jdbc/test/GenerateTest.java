package com.mycomp.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mycomp.jdbc.util.JDBCUtil;

/*
 * 获取数据库自动生成的组件
 */

public class GenerateTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into student(name, age) values (?, ?)";
        PreparedStatement prepareStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);
        prepareStatement.setString(1, "迪奥布兰度");
        prepareStatement.setInt(2, 300);
        prepareStatement.executeUpdate();
        ResultSet res = prepareStatement.getGeneratedKeys();
        if (res.next()) {
            int id = res.getInt(1);
            System.out.println(id);
        }
        JDBCUtil.close(connection, prepareStatement, res);
    }

    public static void test() throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into student(name, age) values ('迪奥布兰度', 200)";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet res = statement.getGeneratedKeys();
        if (res.next()) {
            int id = res.getInt(1);
            System.out.println(id);
        }
        JDBCUtil.close(connection, statement, res);
    }
}
