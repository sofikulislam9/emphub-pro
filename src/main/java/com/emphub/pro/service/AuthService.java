package com.emphub.pro.service;

import com.emphub.pro.model.User;

public interface AuthService {

    User login(String username, String password);
}
