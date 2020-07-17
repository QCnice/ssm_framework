package com.geek.dao;

import com.geek.pojo.User;

public interface UserDao {
    public User findUserByUserName(String userName);
}
