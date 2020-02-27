package com.it666.jdbc.dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertClass {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc_db";
		String user = "root";
		String pwd = "1234";
		Connection conn = null;
		Statement st = null;
		
		try{
			//1.����ע������
			Class.forName("com.mysql.jdbc.Driver");
			//2.�������ݿ�
			conn = DriverManager.getConnection(url, user, pwd);
			//3.����sql���
			String sql = "insert into stu values (1,'zs',20)";
			st = conn.createStatement();
			//4ִ��sql
			int row = st.executeUpdate(sql);
			System.out.println(row);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			//5.�ͷ���Դ
			if(st != null) {
				try {
					st.close();
				}catch(Exception e) {
					e.printStackTrace();	
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception e) {
					e.printStackTrace();	
				}
			}
			
		}
	}
}
