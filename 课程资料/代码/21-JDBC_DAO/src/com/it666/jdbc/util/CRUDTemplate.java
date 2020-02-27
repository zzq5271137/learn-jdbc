package com.it666.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.it666.jdbc.domain.Student;
import com.it666.jdbc.handler.IResultSetHandler;

public class CRUDTemplate {
	/**
	 * 
	1.���һ������
	2.Ҫ������������
	һ��sql���
	һ������
		��һ������sql���ģ��
		�ڶ�������Ϊ�ɱ����������������ֵ
	3.����ֵ
	����ֵΪint����Ӱ���������
	�ɱ�����ı�����һ������
	 */
	public static int executeUpdate(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 1.��������
			// 2.�������ݿ�
			conn = JdbcUtil.getConn();
			// 3.�������
			ps = conn.prepareStatement(sql);
			// ��������
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			// 4.ִ�����
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.�ͷ���Դ
			JdbcUtil.close(conn, ps, null);
		}
		return 0;
	}

	public static <T>T executeQuery(String sql, IResultSetHandler<T> rh, Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 1.��������
			// 2.�������ݿ�
			conn = JdbcUtil.getConn();
			// 3.�������
			ps = conn.prepareStatement(sql);
			// ��������
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			// 4.ִ�����
			rs = ps.executeQuery();
			return rh.handle(rs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.�ͷ���Դ
			JdbcUtil.close(conn, ps, rs);
		}
		return null;
	}

}
