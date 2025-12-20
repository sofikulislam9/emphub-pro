package com.emphub.pro.service.impl;

import com.emphub.pro.dao.AttendanceDao;
import com.emphub.pro.model.Attendance;
import com.emphub.pro.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceDao attendanceDao;

    @Override
    public void checkIn(int employeeId) {
        attendanceDao.checkIn(employeeId);
    }

    @Override
    public void checkOut(int employeeId) {
        attendanceDao.checkOut(employeeId);
    }

    @Override
    public List<Attendance> getAttendance(int employeeId) {
        return attendanceDao.getAttendanceByEmployee(employeeId);
    }
}
