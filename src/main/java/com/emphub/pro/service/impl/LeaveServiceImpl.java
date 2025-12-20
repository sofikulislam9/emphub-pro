package com.emphub.pro.service.impl;

import com.emphub.pro.dao.LeaveDao;
import com.emphub.pro.model.LeaveRequest;
import com.emphub.pro.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveDao leaveDao;

    @Override
    public void applyLeave(LeaveRequest leave) {
        leaveDao.applyLeave(leave);
    }

    @Override
    public List<LeaveRequest> getEmployeeLeaves(int employeeId) {
        return leaveDao.getLeavesByEmployee(employeeId);
    }

    @Override
    public List<LeaveRequest> getAllLeaves() {
        return leaveDao.getAllLeaves();
    }

    @Override
    public void updateLeaveStatus(int leaveId, String status) {
        leaveDao.updateStatus(leaveId, status);
    }
}
