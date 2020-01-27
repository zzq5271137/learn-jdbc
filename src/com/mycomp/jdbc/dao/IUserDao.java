package com.mycomp.jdbc.dao;

import java.util.List;

import com.mycomp.jdbc.domain.User;

public interface IUserDao {

    void save(User user);

    List<User> getAll();

}
