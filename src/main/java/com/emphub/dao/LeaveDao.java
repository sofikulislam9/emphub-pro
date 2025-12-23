package com.emphub.dao;

import com.emphub.model.LeaveRequest;

import java.util.List;

public interface LeaveDao {

    void applyLeave(LeaveRequest leave);

    boolean hasPendingLeave(int employeeId);

    List<LeaveRequest> findAll();

    List<LeaveRequest> findByEmployeeId(int employeeId);

    void updateStatus(int leaveId, String status);

}
