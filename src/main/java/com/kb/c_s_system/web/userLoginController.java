package com.kb.c_s_system.web;

import com.kb.c_s_system.bean.Coach;
import com.kb.c_s_system.bean.Manager;
import com.kb.c_s_system.bean.Member;
import com.kb.c_s_system.bean.extend.UserOut;
import com.kb.c_s_system.service.Impl.CourseServiceImpl;
import com.kb.c_s_system.service.Impl.coachServiceImpl;
import com.kb.c_s_system.service.Impl.managerServiceImpl;
import com.kb.c_s_system.service.Impl.memberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class userLoginController {

    @Autowired
    private coachServiceImpl coachServiceImpl;
    @Autowired
    private memberServiceImpl   memberServiceImpl;
    @Autowired
    private managerServiceImpl  managerServiceImpl;

    @ResponseBody
    @PostMapping("/userLogin")
    public UserOut userLogin(String userID , String password){
        UserOut out = new UserOut();
        Coach coach = coachServiceImpl.findCoachUserByIdAndPw(userID, password);
        Member member = memberServiceImpl.findMemberUserByIdAndPw(userID, password);
        Manager manager = managerServiceImpl.findManagerByIdAndPw(userID, password);
        if(coach!=null){
            Integer coachid = coach.getCoachid();
            String name = coach.getName();
            String gender = coach.getGender();
            Integer level = coach.getLevel();
            String reserve = coach.getReserve();
            Integer age = coach.getAge();

            out.setName(name);
            out.setGender(gender);
            out.setLevel(level.toString());
            out.setId(coachid.toString());
            out.setReserve(reserve);
            out.setAge(age.toString());
            out.setPassword(password);
            return out;
        }else if(member!=null){
            Integer cardid = member.getCardid();
            String gender = member.getGender();
            String name = member.getName();
            Integer level = member.getLevel();
            Date startdate = member.getStartdate();
            Date expirydate = member.getExpirydate();
            String reserve = member.getReserve();
            Integer age = member.getAge();
            out.setName(name);
            out.setLevel(level.toString());
            out.setName(name);
            out.setStartDate(startdate);
            out.setExpiryDate(expirydate);
            out.setId(cardid.toString());
            out.setGender(gender);
            out.setReserve(reserve);
            out.setAge(age.toString());
            out.setPassword(password);
            return out;
        }else if(manager!=null){
            Integer managerid = manager.getManagerid();
            String name = manager.getName();
            String gender = manager.getGender();
            Integer level = manager.getLevel();
            String reserve = manager.getReserve();
            Integer age = manager.getAge();
            out.setId(managerid.toString());
            out.setName(name);
            out.setGender(gender);
            out.setLevel(level.toString());
            out.setReserve(reserve);
            out.setAge(age.toString());
            out.setPassword(password);
            return out;
        }else {
            return null;
        }
    }

}
