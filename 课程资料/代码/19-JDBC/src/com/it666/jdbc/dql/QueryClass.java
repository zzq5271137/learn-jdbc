package com.it666.jdbc.dql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryClass {
	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/jdbc_db";
		String user = "root";
		String pwd = "1234";
		// 1.��������
		Class.forName("com.mysql.jdbc.Driver");
		// 2.�������ݿ�
		Connection conn = DriverManager.getConnection(url, user, pwd);
		// 3.��дsql
		String sql = "SELECT * from emp";
		Statement st = conn.createStatement();
		// 4.ִ��sql
		ResultSet res = st.executeQuery(sql);
		// if(res.next()) {
		// int empno = res.getInt("empno");
		// String ename = res.getString("ename");
		// String job = res.getString("job");
		// System.out.println("empno = "+empno+" name = "+ename+" job = "+job);
		// }
		while (res.next()) {
			int empno = res.getInt("empno");
			String ename = res.getString("ename");
			String job = res.getString("job");
			System.out.println("empno = " + empno + " name = " + ename + " job = " + job);
		}
		// 5.�ͷ���Դ
		st.close();
		conn.close();

	}

	void test2() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc_db";
		String user = "root";
		String pwd = "1234";
		// 1.��������
		Class.forName("com.mysql.jdbc.Driver");
		// 2.�������ݿ�
		Connection conn = DriverManager.getConnection(url, user, pwd);
		// 3.��дsql
		String sql = "SELECT * from emp WHERE ename = '³��'";
		Statement st = conn.createStatement();
		// 4.ִ��sql
		ResultSet res = st.executeQuery(sql);
		if (res.next()) {
			int empno = res.getInt("empno");
			String ename = res.getString("ename");
			String job = res.getString("job");
			System.out.println("empno = " + empno + " name = " + ename + " job = " + job);
		}
		// 5.�ͷ���Դ
		st.close();
		conn.close();
	}

	void test() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc_db";
		String user = "root";
		String pwd = "1234";
		// 1.��������
		Class.forName("com.mysql.jdbc.Driver");
		// 2.�������ݿ�
		Connection conn = DriverManager.getConnection(url, user, pwd);
		// 3.��дsql
		String sql = "SELECT count(*) as total from emp";
		Statement st = conn.createStatement();
		// 4.ִ��sql
		ResultSet res = st.executeQuery(sql);
		if (res.next()) {
			// int count = res.getInt(1);
			int count = res.getInt("total");
			System.out.println(count);
		}
		// 5.�ͷ���Դ
		st.close();
		conn.close();
	}
}
