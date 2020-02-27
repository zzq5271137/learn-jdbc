package com.it666.jdbc.test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import com.it666.jdbc.domain.User;

class ClassTest{
	public Class c;
	public ClassTest(Class c) {
		this.c = c;
	}
}

public class Test {
	
	public static void main(String[] args) throws Exception {
		
	/*	ClassTest ct =  new ClassTest(User.class);
		User u = (User) ct.c.newInstance();*/
		User u = User.class.newInstance();
		//��ȡָ���ֽ����������Ϣ
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class,Object.class);
		//��ȡ���е�����������
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			//��ȡ�������Ե�����
			//System.out.println(pd.getName());
			//��ȡget����
			///System.out.println(pd.getReadMethod());
			System.out.println(pd.getWriteMethod());
			pd.getWriteMethod().invoke(u, "111");
		}
		System.out.println(u.getName());
		System.out.println(u.getPwd());
		
	}
}
