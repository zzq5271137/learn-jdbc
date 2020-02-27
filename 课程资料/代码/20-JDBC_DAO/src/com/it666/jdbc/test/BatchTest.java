package com.it666.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.it666.jdbc.util.JdbcUtil;

public class BatchTest {
	public static void main(String[] args) throws Exception {
		
		 Connection conn = JdbcUtil.getConn();
		 String sql = "insert into student (name,age) values (?,?)";
		 
		 PreparedStatement ps = conn.prepareStatement(sql);
		 long begin  = System.currentTimeMillis();
		 for( int i = 0; i < 1000; i++) {
			 ps.setString(1, "zs");
			 ps.setInt(2, 10);
			 //��ӵ�������
			 ps.addBatch();
		 }
		 //ִ��������
		 ps.executeBatch();
		 long end  = System.currentTimeMillis();
		 long time = end - begin;
		 System.out.println(time);
		 
		 JdbcUtil.close(conn, ps, null);
		
	}
}
