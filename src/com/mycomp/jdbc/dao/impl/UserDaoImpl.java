package com.mycomp.jdbc.dao.impl;

import java.util.List;

import com.mycomp.jdbc.dao.IUserDao;
import com.mycomp.jdbc.domain.User;
import com.mycomp.jdbc.handler.BeanListHandler;
import com.mycomp.jdbc.util.CRUDTemplate;

public class UserDaoImpl implements IUserDao {

    @Override
    public void save(User user) {
        String sql = "insert into user(username, password) values(?,?)";
        CRUDTemplate.executeUpdate(sql, user.getUsername(),
                user.getPassword());
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from user";
        return CRUDTemplate.executeQuery(sql,
                new BeanListHandler<User>(User.class));
    }

}
