package com.it666.jdbc.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

public class BeanHandler<T> implements IResultSetHandler<T>{
	private Class<T> classType;
	public BeanHandler(Class<T> classType) {
		this.classType = classType;
	}
	@Override
	public T handle(ResultSet rs) throws Exception {

		if(rs.next()) {
			
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
			return obj;			
		}
		
		return null;
	}
	
	
	
	
}
