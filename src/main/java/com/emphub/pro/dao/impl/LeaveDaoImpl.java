package com.emphub.pro.dao.impl;

import com.emphub.pro.dao.LeaveDao;
import com.emphub.pro.model.LeaveRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LeaveDaoImpl implements LeaveDao {

    private JdbcTemplate jdbcTemplate;

    public LeaveDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<LeaveRequest> leaveRowMapper = new RowMapper<LeaveRequest>() {
        @Override
        public LeaveRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
            LeaveRequest l = new LeaveRequest();
            l.setId(rs.getInt("id"));
            l.setEmployeeId(rs.getInt("employee_id"));
            l.setFromDate(rs.getDate("from_date").toLocalDate());
            l.setToDate(rs.getDate("to_date").toLocalDate());
            l.setReason(rs.getString("reason"));
            l.setStatus(rs.getString("status"));
            return l;
        }
    };

    @Override
    public void applyLeave(LeaveRequest leave) {

        String sql = "INSERT INTO leave_requests" +
            "(employee_id, from_date, to_date, reason, status)" +
            "VALUES (?, ?, ?, ?, ?) ";

        jdbcTemplate.update(
                sql,
                leave.getEmployeeId(),
                Date.valueOf(leave.getFromDate()),
                Date.valueOf(leave.getToDate()),
                leave.getReason(),
                "PENDING"
        );
    }

    @Override
    public List<LeaveRequest> getLeavesByEmployee(int employeeId) {
        String sql = "SELECT * FROM leave_requests WHERE employee_id = ?";
        return jdbcTemplate.query(sql, leaveRowMapper, employeeId);
    }

    @Override
    public List<LeaveRequest> getAllLeaves() {
        String sql = "SELECT * FROM leave_requests";
        return jdbcTemplate.query(sql, leaveRowMapper);
    }

    @Override
    public void updateStatus(int leaveId, String status) {
        String sql = "UPDATE leave_requests SET status = ? WHERE id = ?";
        jdbcTemplate.update(sql, status, leaveId);
    }
}
