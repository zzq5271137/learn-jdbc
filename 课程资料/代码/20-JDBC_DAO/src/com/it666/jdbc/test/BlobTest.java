package com.it666.jdbc.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.it666.jdbc.util.JdbcUtil;

public class BlobTest {
	public static void main(String[] args) throws Exception {
		
		//�������ݿ�
		Connection conn = JdbcUtil.getConn();
		String sql  = "select * from student where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, 1);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			//��ȡͼƬ
			Blob blob = rs.getBlob("img");
			//��ȡͼƬ�Ķ�����
			InputStream in = blob.getBinaryStream();
			
			//�ѳ����е��ļ�д������
			Files.copy(in, Paths.get("d:/mysqlIcon.png"));
			
		}
		JdbcUtil.close(conn, ps, rs);
		
	}
	
	
	
	void write() throws Exception {
		Connection conn = JdbcUtil.getConn();
		String sql = "insert into student (img) values(?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		//��ȡ���̵��е��ļ���ת�ɼ�����ܹ�ʶ��Ķ�����
		//InputStream������
		//�ѵ��Ե��е��ļ��ŵ������У����Զ���������������InputStream��
		FileInputStream in = new FileInputStream("d:/icon.png");
		ps.setBlob(1, in);
		ps.executeUpdate();
		JdbcUtil.close(conn, ps, null);
	}
}
