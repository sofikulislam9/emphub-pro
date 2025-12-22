package com.emphub.pro.service.impl;


import com.emphub.pro.dao.AttendanceDao;
import com.emphub.pro.model.Attendance;
import com.emphub.pro.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceDao attendanceDao;


    @Override
    public void checkIn(int employeeId) {

        try {
            attendanceDao.checkIn(employeeId);

        } catch (DuplicateKeyException e) {
            throw new IllegalStateException("Already checked in today");
        }
    }

    @Override
    public void checkOut(int employeeId) {

        Attendance attendance = attendanceDao.getTodayAttendance(employeeId, LocalDate.now());

        if (attendance == null || attendance.getCheckIn() == null) {
            throw new IllegalStateException(
                    "You haven’t checked in yet. Please check in before checking out."
            );
        }

        if (attendance.getCheckOut() != null) {
            throw new IllegalStateException(
                    "You have already checked out for today."
            );
        }

        attendanceDao.checkOut(employeeId);

    }

    @Override
    public List<Attendance> employeeAttendance(int employeeId) {
        return attendanceDao.getAttendanceByEmployee(employeeId);
    }

    @Override
    public List<Attendance> allAttendance() {
        return attendanceDao.getAllAttendance();
    }
}
