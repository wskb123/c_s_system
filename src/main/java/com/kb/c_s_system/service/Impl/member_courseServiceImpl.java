package com.kb.c_s_system.service.Impl;

import com.kb.c_s_system.bean.Course;
import com.kb.c_s_system.bean.Member_course;
import com.kb.c_s_system.bean.Member_courseExample;
import com.kb.c_s_system.dao.CourseMapper;
import com.kb.c_s_system.dao.Member_courseMapper;
import com.kb.c_s_system.service.member_courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class member_courseServiceImpl implements member_courseService {
    @Autowired
    private Member_courseMapper member_courseMapper;

    @Autowired
    private CourseMapper courseMapper;
    @Override
    public String saveOrUpdateMem_Course(Member_course m_c) {
        //获取会员id
        Integer id = m_c.getCardid();
//        获取课程id
        Integer courseid1 = m_c.getCourseid();
        Member_courseExample example = new Member_courseExample();
        Member_courseExample.Criteria criteria = example.createCriteria();
        criteria.andCardidEqualTo(id);
        List<Member_course> member_courses = member_courseMapper.selectByExample(example);
        List<Integer> courselist = new ArrayList<Integer>();
        for (int i=0;i<member_courses.size();i++){
//            获取课程id
            Integer courseid = member_courses.get(i).getCourseid();
            courselist.add(courseid);
        }
        //如果选课人数已达上限
        Member_courseExample example1 = new Member_courseExample();
        Member_courseExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andCourseidEqualTo(courseid1);
        Course course = courseMapper.selectByPrimaryKey(courseid1);
        Integer numLimit = course.getNumLimit();
        List<Member_course> member_courses1 = member_courseMapper.selectByExample(example1);
        if(member_courses1.size()>=numLimit){
            return "上课人数已达上限";
        }

//        如果会员没有该课程
        if(!courselist.contains(courseid1)){

            member_courseMapper.insert(m_c);
            return "新增课程";
        }else{
            return "课程已存在";
        }



    }

    @Override
    public List<Integer> findAllCourseIdByCardId(int cardid) {
        Member_courseExample example = new Member_courseExample();
        Member_courseExample.Criteria criteria = example.createCriteria();
        criteria.andCardidEqualTo(cardid);
        List<Member_course> member_courses = member_courseMapper.selectByExample(example);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<member_courses.size();i++){
            Integer courseid = member_courses.get(i).getCourseid();
            list.add(courseid);
        }
        return list;
    }

    @Override
    public Integer findNumByCourseId(int courseid) {
        Member_courseExample example = new Member_courseExample();
        Member_courseExample.Criteria criteria = example.createCriteria();
        criteria.andCourseidEqualTo(courseid);
        List<Member_course> list = member_courseMapper.selectByExample(example);

        return list.size();
    }
}
