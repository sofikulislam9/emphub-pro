package com.emphub.pro.dao;

import com.emphub.pro.model.Attendance;

import java.util.List;

public interface AttendanceDao {

    void checkIn(int employeeId);
    void checkOut(int employeeId);
    List<Attendance> getAttendanceByEmployee(int employeeId);
}
