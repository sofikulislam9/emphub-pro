package com.emphub.pro.dao.impl;

import com.emphub.pro.dao.EmployeeDao;
import com.emphub.pro.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String LOGIN_SQL =
            "SELECT id, name, username, email, department, designation, join_date " +
                    "FROM employee WHERE username = ? AND email = ?";

    private static final String SELECT_ALL =
            "SELECT id, name, username, email, department, designation, join_date FROM employee";

    @Override
    public Employee findByUsernameAndEmail(String username, String email) {

        try {
            return jdbcTemplate.queryForObject(
                    LOGIN_SQL,
                    (rs, rowNum) -> {
                        Employee e = new Employee();
                        e.setId(rs.getInt("id"));
                        e.setName(rs.getString("name"));
                        e.setUsername(rs.getString("username"));
                        e.setEmail(rs.getString("email"));
                        e.setDepartment(rs.getString("department"));
                        e.setDesignation(rs.getString("designation"));
                        e.setJoinDate(rs.getDate("join_date").toLocalDate());
                        return e;
                    },
                    username,
                    email
            );
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Employee> findAll() {

        return jdbcTemplate.query(SELECT_ALL, (rs, rowNum) -> {
            Employee e = new Employee();
            e.setId(rs.getInt("id"));
            e.setName(rs.getString("name"));
            e.setUsername(rs.getString("username"));
            e.setEmail(rs.getString("email"));
            e.setDepartment(rs.getString("department"));
            e.setDesignation(rs.getString("designation"));
            e.setJoinDate(rs.getDate("join_date").toLocalDate());
            return e;
        });
    }
}



