package com.emphub.pro.dao.impl;

import com.emphub.pro.dao.AttendanceDao;
import com.emphub.pro.model.Attendance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public class AttendanceDaoImpl implements AttendanceDao {

    private JdbcTemplate jdbcTemplate;

    public AttendanceDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void checkIn(int employeeId) {

        String sql = "INSERT INTO attendance (employee_id, date, check_in) VALUES (?, ?, ?)";

        jdbcTemplate.update(
                sql,
                employeeId,
                Date.valueOf(LocalDate.now()),
                Time.valueOf(LocalTime.now())
        );
    }

    @Override
    public void checkOut(int employeeId) {

        String selectSql =
                "SELECT id, check_in FROM attendance WHERE employee_id=? AND date=?";

        String updateSql =
                "UPDATE attendance SET check_out=?, total_hours=? WHERE id=?";

        jdbcTemplate.query(selectSql,
                new Object[]{employeeId, Date.valueOf(LocalDate.now())},
                rs -> {

                    int attendanceId = rs.getInt("id");
                    LocalTime checkIn = rs.getTime("check_in").toLocalTime();
                    LocalTime checkOut = LocalTime.now();

                    double totalHours =
                            Duration.between(checkIn, checkOut).toMinutes() / 60.0;

                    jdbcTemplate.update(
                            updateSql,
                            Time.valueOf(checkOut),
                            totalHours,
                            attendanceId
                    );
                }
        );
    }

    @Override
    public List<Attendance> getAttendanceByEmployee(int employeeId) {

        String sql = "SELECT * FROM attendance WHERE employee_id=?";

        return jdbcTemplate.query(
                sql,
                new Object[]{employeeId},
                (rs, rowNum) -> {

                    Attendance a = new Attendance();

                    a.setId(rs.getInt("id"));
                    a.setEmployeeId(rs.getInt("employee_id"));
                    a.setDate(rs.getDate("date").toLocalDate());

                    Time checkIn = rs.getTime("check_in");
                    if (checkIn != null) {
                        a.setCheckIn(checkIn.toLocalTime());
                    }

                    Time checkOut = rs.getTime("check_out");
                    if (checkOut != null) {
                        a.setCheckOut(checkOut.toLocalTime());
                    }

                    a.setTotalHours(rs.getDouble("total_hours"));
                    return a;
                }
        );
    }
}


