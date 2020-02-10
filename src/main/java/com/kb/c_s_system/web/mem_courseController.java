package com.kb.c_s_system.web;

import com.kb.c_s_system.bean.Member_course;
import com.kb.c_s_system.service.Impl.member_courseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class mem_courseController {
    @Autowired
    private member_courseServiceImpl member_courseService;

    @ResponseBody
    @PostMapping("/saveOrUpdateMem_Course")
    public String saveOrUpdateMem_Course(Member_course member_course){

        String msg = member_courseService.saveOrUpdateMem_Course(member_course);
        return msg;
    }

    @ResponseBody
    @GetMapping("findAllCourseIdByCardId")
    public List<Integer>    findAllCourseIdByCardId(int cardid){
        List<Integer> list = member_courseService.findAllCourseIdByCardId(cardid);
        return  list;
    }

}
