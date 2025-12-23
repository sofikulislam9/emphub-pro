package com.emphub.service.impl;

import com.emphub.dao.AdminDao;
import com.emphub.model.Admin;
import com.emphub.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(String username, String password) {
        return adminDao.findByUsernameAndPassword(username, password);
    }
}
