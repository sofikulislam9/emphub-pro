package com.emphub.pro.service.impl;

import com.emphub.pro.dao.DashboardDao;
import com.emphub.pro.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private DashboardDao dashboardDao;

    @Override
    public Map<String, Integer> getDashboardStats() {

        Map<String, Integer> map = new HashMap<>();
        map.put("totalEmployees", dashboardDao.getTotalEmployees());
        map.put("presentToday", dashboardDao.getTodayPresent());
        map.put("absentToday", dashboardDao.getTodayAbsent());
        map.put("pendingLeaves", dashboardDao.getPendingLeaves());

        return map;
    }
}
