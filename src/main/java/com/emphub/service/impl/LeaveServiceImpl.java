package com.emphub.service.impl;


import com.emphub.dao.LeaveDao;
import com.emphub.model.LeaveRequest;
import com.emphub.service.LeaveService;
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
    public boolean hasPendingLeave(int employeeId) {
        return leaveDao.hasPendingLeave(employeeId);
    }

    @Override
    public List<LeaveRequest> getAllLeaves() {
        return leaveDao.findAll();
    }

    @Override
    public List<LeaveRequest> getEmployeeLeaves(int employeeId) {
        return leaveDao.findByEmployeeId(employeeId);
    }

    @Override
    public void updateStatus(int leaveId, String status) {
        leaveDao.updateStatus(leaveId, status);
    }
}
