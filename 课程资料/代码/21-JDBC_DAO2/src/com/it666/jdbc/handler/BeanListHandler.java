package com.it666.jdbc.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler<T> implements IResultSetHandler<List<T>>{

	private Class<T> classType;
	public BeanListHandler(Class<T> classType) {
		this.classType = classType;
	}
	
	@Override
	public List<T> handle(ResultSet rs) throws Exception {
		List<T> list = new ArrayList<>();
		while(rs.next()) {
			//����һ������
			T obj = this.classType.newInstance();
			//ͨ����ʡ��������
			BeanInfo bf = Introspector.getBeanInfo(this.classType,Object.class);
			//��ȡ��������������
			PropertyDescriptor[] pds = bf.getPropertyDescriptors();
			//����ÿһ�����Ե����� ��
			for (PropertyDescriptor pd : pds) {
				Object val = rs.getObject(pd.getName());
				//��������������ֵ
				pd.getWriteMethod().invoke(obj, val);
			}
			//�Ѷ����� �����ϵ���
			list.add(obj);
		}
		
		return list;
	}

}
