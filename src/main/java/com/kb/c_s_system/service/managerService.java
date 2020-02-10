package com.kb.c_s_system.service;

import com.kb.c_s_system.bean.Manager;

import java.util.List;

public interface managerService {
    Manager findManagerByIdAndPw(String reserve, String password);
    void insertOrUpdateManager(Manager manager);
    Manager findManagerById(int id);
    void deleteByManagerId(int id);
    List<Manager> findAllManager();
}
