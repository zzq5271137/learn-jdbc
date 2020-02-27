package com.it666.jdbc.test;

import java.util.List;

import org.junit.Test;

import com.it666.jdbc.dao.IStudentDao;
import com.it666.jdbc.dao.impl.StudentDaoImpl;
import com.it666.jdbc.domain.Student;

public class StudentDaoTest {
	@Test
	public void save() {
		// ����һ��ѧ��
		Student stu = new Student();
		stu.setName("���101");
		stu.setAge(21);
		// ��ѧ�����浽���ݿ⵱��
		IStudentDao dao = new StudentDaoImpl();
		dao.save(stu);
	}

	@Test
	public void delete() {
		IStudentDao dao = new StudentDaoImpl();
		dao.delete(10);
	}

	@Test
	public void update() {
		IStudentDao dao = new StudentDaoImpl();
		// ����һ��ѧ��
		Student stu = new Student();
		stu.setName("³��7");
		stu.setAge(7);	
		dao.update(9, stu);
		
	}
	@Test
	public void get(){
		IStudentDao dao = new StudentDaoImpl();
		 Student stu = dao.get(2);
		 System.out.println(stu);
	}

	@Test
	public void getAll(){
		IStudentDao dao = new StudentDaoImpl();
//		List<Student> allStu = dao.getAll();
//		System.out.println(allStu);
		dao.test();
		
	}
	
	@Test
	public void getCount() {
		IStudentDao dao = new StudentDaoImpl();
		System.out.println(dao.getCount());
	}
}
