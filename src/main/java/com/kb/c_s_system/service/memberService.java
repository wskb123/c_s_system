package com.kb.c_s_system.service;

import com.kb.c_s_system.bean.Member;

import java.util.List;

public interface memberService {
    Member findMemberUserByIdAndPw(String userID,String password);
    void insertOrUpdateMember(Member member);
    Member findMemberUserById(int id);
    List<Member>  findAllMember();
    int deleteByMemberId(int id);
}
