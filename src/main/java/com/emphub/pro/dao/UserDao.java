package com.emphub.pro.dao;

import com.emphub.pro.model.User;

public interface UserDao {

    User login(String username, String password);
}
