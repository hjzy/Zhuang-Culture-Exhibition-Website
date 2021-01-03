package com.train.gdmt.user.service.impl;

import com.train.gdmt.user.dao.UserDao;
import com.train.gdmt.user.model.User;
import com.train.gdmt.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username)
    {
        return userDao.getUser(username);
    }
}
