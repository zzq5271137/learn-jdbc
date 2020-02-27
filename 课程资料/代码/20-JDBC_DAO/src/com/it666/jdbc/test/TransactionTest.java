package com.it666.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.it666.jdbc.util.JdbcUtil;

public class TransactionTest {

	public static void main(String[] args) throws Exception {
		/**
		1.���zs�˻����
		2.����zs�˻�1000
		3.����ls�˻�1000
		 */
		Connection conn = JdbcUtil.getConn();
		String sql = "select * from account where name=? and money>?";
		// �������
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "zs");
		ps.setInt(2, 1000);
		ResultSet rs = ps.executeQuery();
		if (!rs.next()) {
			throw new RuntimeException("ûǮ��");
		}
		try {
			//��������
			conn.setAutoCommit(false);
			// 2.����zs�˻�1000
			sql = "update account set money = money - ? where name = ?";
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, 1000);
			ps.setString(2, "zs");
			ps.executeUpdate();
			int a = 1 / 0;
			// 3.����ls�˻�1000
			sql = "update account set money = money + ? where name = ?";
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, 1000);
			ps.setString(2, "ls");
			ps.executeUpdate();
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			JdbcUtil.close(conn, ps, rs);
		}
		
		
	}

}
