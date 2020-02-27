package com.it666.jdbc.dao;

import java.util.List;

import com.it666.jdbc.domain.Student;

public interface IStudentDao {
	/**
	 * ����һ��ѧ��
	 */
	public void save(Student stu);
	/**
	 * ɾ��ѧ��
	 */
	public void delete(int id);
	/**
	 * ����һ��ѧ����Ϣ
	 */
	public void update(int id,Student stu);
	/**
	 * ��ȡָ��ѧ��
	 */
	public Student get(int id);
	/**
	 * ��ȡ���е�ѧ��
	 */
	public List<Student> getAll();
	
	/**
	 * ��ȡѧ��������
	 */
	Integer getCount();
	
	public void test();
	
	
	
}
