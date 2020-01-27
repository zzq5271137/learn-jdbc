package com.mycomp.jdbc.test;

import com.mycomp.jdbc.dao.IUserDao;
import com.mycomp.jdbc.dao.impl.UserDaoImpl;

public class UserTest {
    public static void main(String[] args) {
        IUserDao userDao = new UserDaoImpl();
        System.out.println(userDao.getAll());
    }
}
