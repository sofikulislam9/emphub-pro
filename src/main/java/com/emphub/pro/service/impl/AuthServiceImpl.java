package com.emphub.pro.service.impl;

import com.emphub.pro.dao.UserDao;
import com.emphub.pro.model.User;
import com.emphub.pro.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }
}
