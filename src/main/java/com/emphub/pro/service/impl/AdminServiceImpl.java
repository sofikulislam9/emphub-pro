package com.emphub.pro.service.impl;

import com.emphub.pro.dao.AdminDao;
import com.emphub.pro.model.Admin;
import com.emphub.pro.service.AdminService;
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
