package com.emphub.dao;

import com.emphub.model.Admin;

public interface AdminDao {

    Admin findByUsernameAndPassword(String username, String password);
}
