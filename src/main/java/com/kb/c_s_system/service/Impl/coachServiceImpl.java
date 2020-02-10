package com.kb.c_s_system.service.Impl;

import com.kb.c_s_system.bean.*;
import com.kb.c_s_system.bean.extend.CourseOut;
import com.kb.c_s_system.dao.CoachMapper;
import com.kb.c_s_system.dao.CourseMapper;
import com.kb.c_s_system.dao.Member_courseMapper;
import com.kb.c_s_system.service.coachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class coachServiceImpl  implements coachService {

    @Autowired
    private CoachMapper coachMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private member_courseServiceImpl member_courseService;

    @Autowired
    private Member_courseMapper member_courseMapper;
    @Override
    public List<CourseOut> findAllCourseByCoachId(int id) {

        List<CourseOut> CourseOut = new ArrayList<CourseOut>();
        //按格式输出
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CourseExample example = new CourseExample();
        CourseExample.Criteria criteria = example.createCriteria();
        criteria.andCoachidEqualTo(id);
        List<Course> courses = courseMapper.selectByExample(example);
        for (int i=0;i<courses.size();i++){
            //获取每一门课程的上课人数
            Integer numByCourseId = member_courseService.findNumByCourseId(courses.get(i).getCourseid());

            CourseOut out = new CourseOut();
            out.setCoachid(courses.get(i).getCoachid());
            out.setCourseid(courses.get(i).getCourseid());
            out.setCoursename(courses.get(i).getCoursename());
            out.setNumLimit(numByCourseId+"/"+courses.get(i).getNumLimit().toString());
            if(courses.get(i).getEndtime()!=null) {
                out.setEndtime(dateFormat.format(courses.get(i).getEndtime()));
            }
            if(courses.get(i).getStarttime()!=null) {
                out.setStarttime(dateFormat.format(courses.get(i).getStarttime()));
            }
            CourseOut.add(out);
        }
        return CourseOut;
    }

    @Override
    public List<Coach> findAllCoach() {
        CoachExample example = new CoachExample();
        List<Coach> coaches = coachMapper.selectByExample(example);
//        for (int i=0;i<coaches.size();i++){}
        return coaches;
    }

    @Override
    public void insertOrUpdateCourse(Course course) {
        Integer courseid = course.getCourseid();
        Course course1 = courseMapper.selectByPrimaryKey(courseid);
        CourseExample example = new CourseExample();
        CourseExample.Criteria criteria = example.createCriteria();
        if(course1!=null){//课程存在，则为更新
            criteria.andCourseidEqualTo(courseid);
            courseMapper.updateByPrimaryKey(course);
        }else{//直接新增

            courseMapper.insert(course);
//            courseMapper.insertSelective(course);

        }
    }
    //    删除教练,同时他的课程也要删除，以及中间表的记录也得删除
    @Override
    public int deleteByCoachId(int id) {
        //course
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCoachidEqualTo(id);
        //coach_member
        Member_courseExample member_courseExample = new Member_courseExample();
        Member_courseExample.Criteria criteria1 = member_courseExample.createCriteria();

        List<Course> courses = courseMapper.selectByExample(courseExample);
        for(int i=0;i<courses.size();i++){
            //1,删除coach_member中的记录以及course中的记录
            Integer courseid = courses.get(i).getCourseid();
            criteria1.andCourseidEqualTo(courseid);
            member_courseMapper.deleteByExample(member_courseExample);
            member_courseExample.clear();
        }
        //2,删除course记录
        courseMapper.deleteByExample(courseExample);
        //3,删除教练记录
        int i = coachMapper.deleteByPrimaryKey(id);
        System.out.print("删除教练");
        System.out.print(i);
        return i;
    }

    @Override
    public Coach findCoachUserByIdAndPw(String userID,String password) {
        CoachExample example = new CoachExample();
        CoachExample.Criteria criteria = example.createCriteria();
        criteria.andReserveEqualTo(userID);
        criteria.andPasswordEqualTo(password);
        List<Coach> coaches = coachMapper.selectByExample(example);
        if(coaches.size()!=0){
            return coaches.get(0);
        }else {
            return null;
        }
    }

    @Override
    public void insertOrUpdateCoach(Coach coach) {
        Integer coachid = coach.getCoachid();
        if(coachid!=null){
            Coach coach1 = findCoachById(coachid);
            String name = coach1.getName();
            Integer age = coach1.getAge();
            String gender = coach1.getGender();
            Integer phonenumber = coach1.getPhonenumber();
            Integer level = coach1.getLevel();
            String reserve = coach1.getReserve();
            String reserve2 = coach1.getReserve2();
            if(coach.getName()==null){
                coach.setName(name);
            }
            if(coach.getAge()==null){
                coach.setAge(age);
            }
            if(coach.getGender()==null){
                coach.setGender(gender);
            }
            if(coach.getPhonenumber()==null){
                coach.setPhonenumber(phonenumber);
            }
            if(coach.getLevel()==null){
                coach.setLevel(level);
            }
            if(coach.getReserve()==null){
                coach.setReserve(reserve);
            }
            if(coach.getReserve2()==null){
                coach.setReserve2(reserve2);
            }
            coachMapper.updateByPrimaryKey(coach);
        }else {
            coachMapper.insert(coach);
        }
    }

    @Override
    public Coach findCoachById(int id) {
        Coach coach = coachMapper.selectByPrimaryKey(id);

        return coach;
    }
}
