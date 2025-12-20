package com.emphub.pro.service;

import com.emphub.pro.model.LeaveRequest;

import java.util.List;

public interface LeaveService {

    void applyLeave(LeaveRequest leave);
    List<LeaveRequest> getEmployeeLeaves(int employeeId);
    List<LeaveRequest> getAllLeaves();
    void updateLeaveStatus(int leaveId, String status);

}
