package com.emphub.pro.service;

import com.emphub.pro.model.Attendance;

import java.util.List;

public interface AttendanceService {

    void checkIn(int employeeId);

    void checkOut(int employeeId);

    List<Attendance> employeeAttendance(int employeeId);

    List<Attendance> allAttendance();

}
