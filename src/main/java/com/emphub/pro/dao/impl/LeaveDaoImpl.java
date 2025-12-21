package com.emphub.pro.dao.impl;

import com.emphub.pro.dao.LeaveDao;
import com.emphub.pro.model.LeaveRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LeaveDaoImpl implements LeaveDao {

    private JdbcTemplate jdbcTemplate;

    public LeaveDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void applyLeave(LeaveRequest leave) {

        String sql = "INSERT INTO leave_request (employee_id, from_date, to_date, reason) VALUES (?, ?, ?, ?) ";
        jdbcTemplate.update(
                sql,
                leave.getEmployeeId(),
                leave.getFromDate(),
                leave.getToDate(),
                leave.getReason()
        );
    }

    @Override
    public List<LeaveRequest> findAll() {

        String sql = "SELECT * FROM leave_request";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            LeaveRequest l = new LeaveRequest();
            l.setId(rs.getInt("id"));
            l.setEmployeeId(rs.getInt("employee_id"));
            l.setFromDate(rs.getDate("from_date").toLocalDate());
            l.setToDate(rs.getDate("to_date").toLocalDate());
            l.setReason(rs.getString("reason"));
            l.setStatus(rs.getString("status"));
            return l;
        });
    }

    @Override
    public List<LeaveRequest> findByEmployeeId(int employeeId) {
        String sql = "SELECT * FROM leave_request WHERE employee_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            LeaveRequest l = new LeaveRequest();
            l.setId(rs.getInt("id"));
            l.setFromDate(rs.getDate("from_date").toLocalDate());
            l.setToDate(rs.getDate("to_date").toLocalDate());
            l.setReason(rs.getString("reason"));
            l.setStatus(rs.getString("status"));
            return l;
        }, employeeId);
    }

    @Override
    public void updateStatus(int leaveId, String status) {
        String sql = "UPDATE leave_request SET status = ? WHERE id = ?";
        jdbcTemplate.update(sql, status, leaveId);
    }
}
