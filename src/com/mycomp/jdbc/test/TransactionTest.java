package com.mycomp.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mycomp.jdbc.util.JDBCUtil;

/*
 * 事务处理
 */

public class TransactionTest {
    public static void main(String[] args) throws Exception {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from account where name = ? and money > ?";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, "zs");
        prepareStatement.setDouble(2, 1000);
        ResultSet res = prepareStatement.executeQuery();
        if (!res.next()) {
            throw new RuntimeException("没钱了");
        }

        try {
            connection.setAutoCommit(false);

            sql = "update account set money = money - ? where name = ?";
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setDouble(1, 1000);
            prepareStatement.setString(2, "zs");
            prepareStatement.executeUpdate();

            int a = 1 / 0; // 模拟系统故障

            sql = "update account set money = money + ? where name = ?";
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setDouble(1, 1000);
            prepareStatement.setString(2, "ls");
            prepareStatement.executeUpdate();

            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback(); // 释放资源
        } finally {
            JDBCUtil.close(connection, prepareStatement, res);
        }
    }
}
