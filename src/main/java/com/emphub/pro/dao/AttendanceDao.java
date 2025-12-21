package com.emphub.pro.dao;

import com.emphub.pro.model.Attendance;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceDao {

    void checkIn(int employeeId);

    void checkOut(int employeeId);

    Attendance getTodayAttendance(int employeeId, LocalDate date);

    List<Attendance> getAttendanceByEmployee(int employeeId);

    List<Attendance> getAllAttendance();

}
