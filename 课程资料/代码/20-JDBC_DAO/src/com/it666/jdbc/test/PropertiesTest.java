package com.it666.jdbc.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws Exception {
		//��ȡ�����ļ�
		Properties p = new Properties();
		FileInputStream in = new FileInputStream("resource/db.properties");
		p.load(in);
		//��ȡ�ļ�
		System.out.println(p.getProperty("url"));
		System.out.println(p.getProperty("user"));
	}
	
}
