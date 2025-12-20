package com.emphub.pro.dao.impl;

import com.emphub.pro.dao.EmployeeDao;
import com.emphub.pro.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {


   private JdbcTemplate jdbcTemplate;

   public EmployeeDaoImpl(JdbcTemplate jdbcTemplate){
       this.jdbcTemplate= jdbcTemplate;
   }

    @Override
    public void save(Employee emp) {

        String sql = "INSERT INTO employee " +
                "(name, email, department, designation, join_date, status) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                emp.getName(),
                emp.getEmail(),
                emp.getDepartment(),
                emp.getDesignation(),
                Date.valueOf(emp.getJoinDate()),
                emp.getStatus()
        );

    }

    @Override
    public List<Employee> findAll() {

        String sql = "SELECT * FROM employee";

        return jdbcTemplate.query(sql, (rs, nowNum)-> {

            Employee emp = new Employee();

            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setEmail(rs.getString("email"));
            emp.setDepartment(rs.getString("department"));
            emp.setDesignation(rs.getString("designation"));
            emp.setJoinDate(rs.getDate("join_date").toLocalDate());
            emp.setStatus(rs.getString("status"));

            return emp;
        });

    }
}
