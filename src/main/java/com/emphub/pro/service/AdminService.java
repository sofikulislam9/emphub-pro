package com.emphub.pro.service;

import com.emphub.pro.model.Admin;

public interface AdminService {

    Admin login(String username, String password);
}
