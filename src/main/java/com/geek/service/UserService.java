package com.geek.service;

import com.geek.dao.UserDao;
import com.geek.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Transactional
    public User findUserByUserName(String userName){
        return userDao.findUserByUserName(userName);
    }
}
