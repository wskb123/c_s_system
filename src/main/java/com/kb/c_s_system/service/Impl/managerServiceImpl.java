package com.kb.c_s_system.service.Impl;

import com.kb.c_s_system.bean.Manager;
import com.kb.c_s_system.bean.ManagerExample;
import com.kb.c_s_system.dao.ManagerMapper;
import com.kb.c_s_system.service.managerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class managerServiceImpl implements managerService {
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private coachServiceImpl coachService;
    @Autowired
    private memberServiceImpl  memberService;
    @Override
    public Manager findManagerByIdAndPw(String reserve, String password) {
        ManagerExample example = new ManagerExample();
        ManagerExample.Criteria criteria = example.createCriteria();
        criteria.andReserveEqualTo(reserve);
        criteria.andPasswordEqualTo(password);
        List<Manager> managers = managerMapper.selectByExample(example);
        if(managers.size()!=0){
            return managers.get(0);
        }else {
            return null;
        }
    }

    @Override
    public void insertOrUpdateManager(Manager manager) {
        Integer managerid = manager.getManagerid();
        if(managerid!=null){
            Manager man = findManagerById(managerid);
            String name = man.getName();
            Integer age = man.getAge();
            String gender = man.getGender();
            Integer phonenumber = man.getPhonenumber();
            Integer level = man.getLevel();
            String reserve = man.getReserve();
            String reserve2 = man.getReserve2();
            if(manager.getName()==null){
                manager.setName(name);
            }
            if(manager.getAge()==null){
                manager.setAge(age);
            }
            if(manager.getPhonenumber()==null){
                manager.setPhonenumber(phonenumber);
            }
            if(manager.getGender()==null){
                manager.setGender(gender);
            }
            if(manager.getLevel()==null){
                manager.setLevel(level);
            }
            if(manager.getReserve()==null){
                manager.setReserve(reserve);
            }
            if(manager.getReserve2()==null){
                manager.setReserve2(reserve2);
            }
            managerMapper.updateByPrimaryKey(manager);
        }else {
            managerMapper.insert(manager);
        }
    }

    @Override
    public Manager findManagerById(int id) {
        Manager manager = managerMapper.selectByPrimaryKey(id);
        return manager;
    }

    @Override
    public void deleteByManagerId(int id) {
        managerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Manager> findAllManager() {
        ManagerExample example = new ManagerExample();
        List<Manager> managers = managerMapper.selectByExample(example);
        return managers;
    }
}
