package com.emphub.pro.dao.impl;

import com.emphub.pro.dao.AdminDao;
import com.emphub.pro.model.Admin;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl implements AdminDao {

    private final JdbcTemplate jdbcTemplate;

    public AdminDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    final String LOGIN_SQL =
            "SELECT id, name, username FROM admin WHERE username = ? AND password = ?";


    @Override
    public Admin findByUsernameAndPassword(String username, String password) {

        try {
            return jdbcTemplate.queryForObject(
                    LOGIN_SQL,
                    (rs, rowNum) -> {
                        Admin admin = new Admin();
                        admin.setId(rs.getInt("id"));
                        admin.setName(rs.getString("name"));
                        admin.setUsername(rs.getString("username"));
                        return admin;
                    },
                    username,
                    password
            );
        } catch (Exception e) {
            return null;
        }
    }
}
