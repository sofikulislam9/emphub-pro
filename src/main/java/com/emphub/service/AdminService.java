package com.emphub.service;

import com.emphub.model.Admin;

public interface AdminService {

    Admin login(String username, String password);
}
