package com.it666.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	public static void main(String[] args) throws Exception {
		
		//1.��������
		//��com.mysql.jdbc.Driver����ֽ�����ؽ�JVM
		//��һ���ֽ��뱻���ص�JVMʱ���ͻ�ִ�и��ֽ����еľ�̬�����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.��ȡ���Ӷ���
		//url ���ݿ��ַ
		String url = "jdbc:mysql://localhost:3306/my_test3";
		//�û���
		String user = "root";
		//����
		String password = "1234";
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
		
		Thread.sleep(50000);
		
	}
}
