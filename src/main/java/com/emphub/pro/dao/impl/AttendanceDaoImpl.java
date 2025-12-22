package com.emphub.pro.dao.impl;

import com.emphub.pro.dao.AttendanceDao;
import com.emphub.pro.model.Attendance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Repository
public class AttendanceDaoImpl implements AttendanceDao {

    private JdbcTemplate jdbcTemplate;

    public AttendanceDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Attendance> rowMapper = (ResultSet rs, int rowNum) -> {
        Attendance a = new Attendance();
        a.setId(rs.getInt("id"));
        a.setEmployeeId(rs.getInt("employee_id"));
        a.setAttendanceDate(rs.getDate("attendance_date").toLocalDate());
        a.setCheckIn(rs.getTime("check_in") == null ? null : rs.getTime("check_in").toLocalTime());
        a.setCheckOut(rs.getTime("check_out") == null ? null : rs.getTime("check_out").toLocalTime());
        a.setTotalHours(rs.getDouble("total_hours"));
        return a;
    };

    @Override
    public void checkIn(int employeeId) {

        String sql = "INSERT INTO attendance (employee_id, attendance_date, check_in) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employeeId, LocalDate.now(), LocalTime.now());
    }

    @Override
    public void checkOut(int employeeId) {

        Attendance a = getTodayAttendance(employeeId, LocalDate.now());
        LocalTime checkOut  = LocalTime.now();
        double hours = Duration.between(a.getCheckIn(), checkOut).toMinutes() / 60.0;

        String sql = "UPDATE attendance SET check_out = ?, total_hours = ? WHERE employee_id = ? AND attendance_date = ?";

        jdbcTemplate.update(sql, checkOut, hours, employeeId, LocalDate.now());

    }

    @Override
    public Attendance getTodayAttendance(int employeeId, LocalDate date) {

        String sql =  "SELECT * FROM attendance WHERE employee_id = ? AND attendance_date = ?";

        List<Attendance> list = jdbcTemplate.query(sql, rowMapper, employeeId, date);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Attendance> getAttendanceByEmployee(int employeeId) {

        String sql = "SELECT * FROM attendance WHERE employee_id = ? ORDER BY attendance_date  DESC";

        return jdbcTemplate.query(sql, rowMapper, employeeId);
    }

    @Override
    public List<Attendance> getAllAttendance() {

        String sql = "SELECT * FROM attendance ORDER BY attendance_date  DESC";
        return jdbcTemplate.query(sql, rowMapper);
    }
}
