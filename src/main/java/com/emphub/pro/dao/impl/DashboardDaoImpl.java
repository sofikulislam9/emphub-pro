package com.emphub.pro.dao.impl;

import com.emphub.pro.dao.DashboardDao;
import org.springframework.jdbc.core.JdbcTemplate;



public class DashboardDaoImpl implements DashboardDao {

   private JdbcTemplate jdbcTemplate;

    public DashboardDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getTotalEmployees() {
        String sql = "SELECT COUNT(*) FROM employees";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int getTodayPresent() {
        String sql = "SELECT COUNT(DISTINCT employee_id) FROM attendance WHERE date = CURDATE()";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int getTodayAbsent() {
        String sql = "SELECT COUNT(*) FROM employees WHERE id NOT IN " +
                "(SELECT employee_id FROM attendance WHERE date = CURDATE())";

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int getPendingLeaves() {
        String sql = "SELECT COUNT(*) FROM leave_requests WHERE status = 'PENDING'";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
