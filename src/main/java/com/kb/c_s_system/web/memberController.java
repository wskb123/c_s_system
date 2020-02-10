package com.kb.c_s_system.web;

import com.kb.c_s_system.bean.Member;

import com.kb.c_s_system.service.Impl.coachServiceImpl;
import com.kb.c_s_system.service.Impl.memberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class memberController {

    @Autowired
    private memberServiceImpl memberService;

    @Autowired
    private coachServiceImpl  coachService;

    @ResponseBody
    @PostMapping("/insertOrUpdateMember")
    public void insertOrUpdateMember(Member member){

        memberService.insertOrUpdateMember(member);
    }

    @ResponseBody
    @GetMapping("findMemberUserByIdAndPw")
    public Member findMemberUserByIdAndPw(String userID,String password){
        Member member = memberService.findMemberUserByIdAndPw(userID, password);
        return member;
    }
}
