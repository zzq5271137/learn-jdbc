package com.it666.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.it666.jdbc.util.JdbcUtil;

public class GenerateTest {
	public static void main(String[] args) throws Exception {
		
		 Connection conn = JdbcUtil.getConn();
		 String sql = "insert into student (name,age) values (?,?)";
		//���ÿ��Ի�ȡ����
		 PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		 ps.setString(1, "����");
		 ps.setInt(2, 20);
		 ps.executeUpdate();
		 
		 ResultSet rs = ps.getGeneratedKeys();
		 if(rs.next()) {
			  int id = rs.getInt(1);
			  System.out.println(id);
		  }
		 JdbcUtil.close(conn, ps, null);
	
	}
	
	void test() throws Exception {
		 Connection conn = JdbcUtil.getConn();
		 String sql = "insert into student (name,age) values ('����',30)";
		 
		 Statement st = conn.createStatement();
		 //���ÿ��Ի�ȡ����
		 st.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
		 //��ȡ�Զ����ɵ�id
		  ResultSet rs = st.getGeneratedKeys();
		  if(rs.next()) {
			  int id = rs.getInt(1);
			  System.out.println(id);
		  }
		 JdbcUtil.close(conn, st, null);
	}
	
}
