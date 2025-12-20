package com.emphub.pro.dao.impl;

import com.emphub.pro.dao.UserDao;
import com.emphub.pro.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User login(String username, String password) {

        String sql = "SELECT * FROM users WHERE username=? AND password=? AND status='ACTIVE'";

        return jdbcTemplate.queryForObject(sql, new Object[]{username, password}, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
                u.setStatus(rs.getString("status"));
                return u;
            }
        });
    }
}
