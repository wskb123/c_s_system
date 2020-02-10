package com.kb.c_s_system.web;

import com.kb.c_s_system.bean.Coach;
import com.kb.c_s_system.bean.Manager;
import com.kb.c_s_system.bean.Member;
import com.kb.c_s_system.service.Impl.coachServiceImpl;
import com.kb.c_s_system.service.Impl.managerServiceImpl;
import com.kb.c_s_system.service.Impl.memberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class managerController {
    @Autowired
    private managerServiceImpl managerService;

    @Autowired
    private memberServiceImpl memberService;
    @Autowired
    private coachServiceImpl coachService;
    @ResponseBody
    @GetMapping("findManagerByIdAndPw")
    public Manager findManagerByIdAndPw(String userID,String password){
        Manager manager = managerService.findManagerByIdAndPw(userID, password);
        return manager;
    }

    @ResponseBody
    @GetMapping("findAllManager")
    public List<Manager> findAllManager(){
        List<Manager> allManager = managerService.findAllManager();
        return allManager;
    }
//  经理增改
    @ResponseBody
    @PostMapping("/insertOrUpdateManager")
    public void insertOrUpdateManager(Manager manager){
        managerService.insertOrUpdateManager(manager);
    }

//    删除经理
    @ResponseBody
    @GetMapping("deleteByManagerId")
    public void deleteByManagerId(int id){
        managerService.deleteByManagerId(id);
    }

//    删除教练,同时他的课程也要删除，以及中间表的记录也得删除
    @ResponseBody
    @GetMapping("deleteByCoachId")
    public void deleteByCoachId(int id){
        coachService.deleteByCoachId(id);
    }

//    删除会员
    @ResponseBody
    @GetMapping("deleteByMemberId")
    public  void deleteByMemberId(int id){
        memberService.deleteByMemberId(id);
    }
    //查询所有教练
    @ResponseBody
    @GetMapping("findAllCoach")
    public List<Coach>  findAllCoach(){
        List<Coach> allCoach = coachService.findAllCoach();
        return allCoach;
    }

    //查询所有会员
    @ResponseBody
    @GetMapping("findAllMember")
    public  List<Member> findAllMember(){
        List<Member> allMember = memberService.findAllMember();
        return allMember;
    }
}
