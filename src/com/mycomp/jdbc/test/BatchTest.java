package com.mycomp.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mycomp.jdbc.util.JDBCUtil;

/*
 * 批处理
 */

public class BatchTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtil.getConnection();

        String sql = "insert into student(name, age) values(?,?)";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);

        prepareStatement.setString(1, "乔纳森乔斯塔");
        prepareStatement.setInt(2, 20);
        prepareStatement.addBatch();

        prepareStatement.setString(1, "乔瑟夫乔斯塔");
        prepareStatement.setInt(2, 60);
        prepareStatement.addBatch();

        prepareStatement.setString(1, "空条承太郎");
        prepareStatement.setInt(2, 17);
        prepareStatement.addBatch();

        prepareStatement.executeBatch();

        JDBCUtil.close(connection, prepareStatement, null);
    }
}
