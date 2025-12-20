package com.emphub.pro.dao;

public interface DashboardDao {

    int getTotalEmployees();
    int getTodayPresent();
    int getTodayAbsent();
    int getPendingLeaves();
}
