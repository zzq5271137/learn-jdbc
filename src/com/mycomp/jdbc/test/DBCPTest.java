package com.mycomp.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mycomp.jdbc.domain.Student;
import com.mycomp.jdbc.util.JDBCUtil;

public class DBCPTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from student";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        ResultSet res = prepareStatement.executeQuery();
        while (res.next()) {
            Student student = new Student();
            student.setId(res.getInt("id"));
            student.setName(res.getString("name"));
            student.setAge(res.getInt("age"));
            System.out.println(student);
        }
        JDBCUtil.close(connection, prepareStatement, res);
    }
}
