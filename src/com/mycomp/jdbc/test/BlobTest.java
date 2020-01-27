package com.mycomp.jdbc.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mycomp.jdbc.util.JDBCUtil;

/*
 * 在数据库中存取图片
 */

public class BlobTest {
    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into picture(img) values(?)";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setBlob(1, new FileInputStream(
                "H:\\Eclipse_workspace\\Practise\\resources\\img\\pic2.JPG"));
        prepareStatement.executeUpdate();
        JDBCUtil.close(connection, prepareStatement, null);

        connection = JDBCUtil.getConnection();
        sql = "select * from picture where id = ?";
        prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, 3);
        ResultSet res = prepareStatement.executeQuery();
        if (res.next()) {
            Blob img = res.getBlob("img");
            InputStream binaryStream = img.getBinaryStream();
            Files.copy(binaryStream, Paths.get(
                    "H:\\Eclipse_workspace\\Practise\\resources\\img\\res.JPG"));
        }
        JDBCUtil.close(connection, prepareStatement, null);
    }
}
