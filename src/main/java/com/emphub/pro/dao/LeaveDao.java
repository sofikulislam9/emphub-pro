package com.emphub.pro.dao;

import com.emphub.pro.model.LeaveRequest;

import java.util.List;

public interface LeaveDao {

    void applyLeave(LeaveRequest leave);

    List<LeaveRequest> findAll();

    List<LeaveRequest> findByEmployeeId(int employeeId);

    void updateStatus(int leaveId, String status);


}
