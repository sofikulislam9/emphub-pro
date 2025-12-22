package com.emphub.pro.dao.impl;

import com.emphub.pro.dao.EmployeeDao;
import com.emphub.pro.model.Employee;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String LOGIN_SQL =
            "SELECT * FROM employee WHERE username = ? AND email = ?";

    private static final String SELECT_ALL =
            "SELECT * FROM employee";

    private static final String FINDBYID_SQL =
            "SELECT * FROM employee WHERE id=?";

    private static final String SAVE_SQL =
            "INSERT INTO employee(name,username,email,department,designation,join_date) VALUES (?,?,?,?,?,?)";

    private static final String UPDATE_SQL =
            "UPDATE employee SET name=?, username=?, email=?, department=?, designation=?, join_date=? WHERE id=?";

    private static final String DELETE_SQL =
            "DELETE FROM employee WHERE id=?";

    private final RowMapper<Employee> rowMapper = new RowMapper<Employee>() {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee e = new Employee();
            e.setId(rs.getInt("id"));
            e.setName(rs.getString("name"));
            e.setUsername(rs.getString("username"));
            e.setEmail(rs.getString("email"));
            e.setDepartment(rs.getString("department"));
            e.setDesignation(rs.getString("designation"));
            e.setJoinDate(rs.getDate("join_date").toLocalDate());
            return e;
        }
    };


    @Override
    public Employee findByUsernameAndEmail(String username, String email) {

        List<Employee> employees = jdbcTemplate.query(LOGIN_SQL, rowMapper, username, email);

            return employees.isEmpty() ? null : employees.get(0);
    }

    @Override
    public List<Employee> findAll() {

        return jdbcTemplate.query(SELECT_ALL, rowMapper);
    }

    @Override
    public Employee findById(int id) {
        return jdbcTemplate.queryForObject(FINDBYID_SQL, rowMapper, id);
    }

    @Override
    public boolean save(Employee employee) {

        try {
            jdbcTemplate.update(SAVE_SQL, employee.getName(), employee.getUsername(),
                    employee.getEmail(), employee.getDepartment(), employee.getDesignation(),
                    employee.getJoinDate());
            return true;

        } catch (DuplicateKeyException e) {
            return false;
        }
    }

    @Override
    public boolean update(Employee employee) {

        try {

            jdbcTemplate.update(UPDATE_SQL, employee.getName(), employee.getUsername(),
                    employee.getEmail(), employee.getDepartment(), employee.getDesignation(),
                    employee.getJoinDate(), employee.getId());

            return true;

        } catch (DuplicateKeyException e) {
            return false;
        }
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_SQL, id);
    }
}



