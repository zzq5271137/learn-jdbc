package com.mycomp.jdbc.test;

import com.mycomp.jdbc.dao.IStudentDao;
import com.mycomp.jdbc.dao.impl.StudentDaoImpl;

public class StudentTest {
    public static void main(String[] args) {
        IStudentDao studentDao = new StudentDaoImpl();
        System.out.println(studentDao.getCount());
    }
}
