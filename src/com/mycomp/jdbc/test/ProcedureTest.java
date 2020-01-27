package com.mycomp.jdbc.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.mycomp.jdbc.util.JDBCUtil;

/*
 * 调用MySql存储过程
 */

public class ProcedureTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        String call = "{ call getName(?,?)}";
        CallableStatement prepareCall = connection.prepareCall(call);
        prepareCall.setInt(1, 9);
        prepareCall.registerOutParameter(2, Types.VARCHAR);
        prepareCall.execute();
        String name = prepareCall.getString(2);
        System.out.println(name);
        JDBCUtil.close(connection, prepareCall, null);
    }
}
