package com.kb.c_s_system.service.Impl;

import com.kb.c_s_system.bean.Member;
import com.kb.c_s_system.bean.MemberExample;
import com.kb.c_s_system.bean.Member_course;
import com.kb.c_s_system.bean.Member_courseExample;
import com.kb.c_s_system.dao.MemberMapper;
import com.kb.c_s_system.dao.Member_courseMapper;
import com.kb.c_s_system.service.memberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class memberServiceImpl implements memberService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private Member_courseMapper member_courseMapper;
    @Override
    public Member findMemberUserByIdAndPw(String userID,String password) {
        MemberExample example = new MemberExample();
        MemberExample.Criteria criteria = example.createCriteria();
        criteria.andReserveEqualTo(userID);
        criteria.andPasswordEqualTo(password);
        List<Member> members = memberMapper.selectByExample(example);
        if(members.size()!=0){
            return members.get(0);
        }else {
            return null;
        }
    }

    @Override
    public void insertOrUpdateMember(Member member) {
        Integer cardid = member.getCardid();
        //修改
        if(member.getCardid()!=null){
            Member member1 = findMemberUserById(cardid);
            String name = member1.getName();
            Integer age = member1.getAge();
            String gender = member1.getGender();
            if(member.getStartdate()==null) {
                if (member1.getStartdate() != null) {
                    Date startdate = member1.getStartdate();
                    member.setStartdate(startdate);
                }
            }
            if(member.getExpirydate()==null){
                if(member1.getExpirydate()!=null) {
                    Date expirydate = member1.getExpirydate();
                    member.setExpirydate(expirydate);
                }
            }
            Integer phonenumber = member1.getPhonenumber();
            Integer level = member1.getLevel();
            String reserve = member1.getReserve();
            String reserve2 = member1.getReserve2();
            if(member.getName()==null){
                member.setName(name);
            }
            if(member.getGender()==null){
                member.setGender(gender);
            }
            if(member.getAge()==null){
                member.setAge(age);
            }
            if(member.getPhonenumber()==null){
                member.setPhonenumber(phonenumber);
            }
            if(member.getLevel()==null){
                member.setLevel(level);
            }
            if(member.getReserve()==null){
                member.setReserve(reserve);
            }
            if(member.getReserve2()==null){
                member.setReserve2(reserve2);
            }
            memberMapper.updateByPrimaryKey(member);
        }else {
            memberMapper.insert(member);
        }
    }

    @Override
    public Member findMemberUserById(int id) {
        Member member = memberMapper.selectByPrimaryKey(id);

        return member;
    }

    @Override
    public List<Member> findAllMember() {
        MemberExample example = new MemberExample();
        List<Member> members = memberMapper.selectByExample(example);
        return members;
    }

    @Override
    public int deleteByMemberId(int id) {
        Member_courseExample member_courseExample = new Member_courseExample();
        Member_courseExample.Criteria criteria = member_courseExample.createCriteria();
        criteria.andCardidEqualTo(id);
        List<Member_course> member_courses = member_courseMapper.selectByExample(member_courseExample);
        for(int i=0;i<member_courses.size();i++){
            //删除member_course的记录
            Integer id1 = member_courses.get(i).getId();
            member_courseMapper.deleteByPrimaryKey(id1);
        }
        int i = memberMapper.deleteByPrimaryKey(id);
        return i;
    }
}
