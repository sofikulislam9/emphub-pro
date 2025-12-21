package com.emphub.pro.service;

import com.emphub.pro.model.LeaveRequest;

import java.util.List;

public interface LeaveService {

    void applyLeave(LeaveRequest leave);

    List<LeaveRequest> getAllLeaves();

    List<LeaveRequest> getEmployeeLeaves(int employeeId);

    void updateStatus(int leaveId, String status);

}

