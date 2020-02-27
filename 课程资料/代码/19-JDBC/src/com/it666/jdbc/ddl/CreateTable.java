package com.it666.jdbc.ddl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) throws Exception {

		// 1.��������
		// ��com.mysql.jdbc.Driver����ֽ�����ؽ�JVM
		// ��һ���ֽ��뱻���ص�JVMʱ���ͻ�ִ�и��ֽ����еľ�̬�����
		Class.forName("com.mysql.jdbc.Driver");

		// 2.��ȡ���Ӷ���
		// url ���ݿ��ַ
		String url = "jdbc:mysql://localhost:3306/jdbc_db";
		// �û���
		String user = "root";
		// ����
		String password = "1234";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		//3.��дsql���
		String sql = "create table stu(id int,name varchar(50),age int)";
		Statement st = conn.createStatement();		
		//4.ִ��sql
		int row =  st.executeUpdate(sql);
		//5.�ͷ���Դ 
		st.close();
		conn.close();
	}

}
