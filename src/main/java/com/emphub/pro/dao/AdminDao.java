package com.emphub.pro.dao;

import com.emphub.pro.model.Admin;

public interface AdminDao {

    Admin findByUsernameAndPassword(String username, String password);
}
