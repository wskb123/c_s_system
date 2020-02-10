package com.kb.c_s_system.service.Impl;

import com.kb.c_s_system.bean.Course;
import com.kb.c_s_system.bean.CourseExample;
import com.kb.c_s_system.bean.extend.CourseOut;
import com.kb.c_s_system.dao.CourseMapper;
import com.kb.c_s_system.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements courseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private member_courseServiceImpl member_courseService;

    @Override
    public int deleteByCourseId(int id) {
//        CourseExample example = new CourseExample();
//        CourseExample.Criteria criteria = example.createCriteria();
//        criteria.andCourseidEqualTo(id);
        int i = courseMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public List<CourseOut> findAllCourse() {
        CourseExample example = new CourseExample();
        List<Course> courses = courseMapper.selectByExample(example);
        List<CourseOut> CourseOut = new ArrayList<CourseOut>();
        //按格式输出
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i=0;i<courses.size();i++){
            //获取每一门课程的上课人数
            Integer numByCourseId = member_courseService.findNumByCourseId(courses.get(i).getCourseid());

            CourseOut out = new CourseOut();
            Integer courseid = courses.get(i).getCourseid();
            Integer coachid = courses.get(i).getCoachid();
            String coursename = courses.get(i).getCoursename();
            Integer numLimit = courses.get(i).getNumLimit();
            String reserve = courses.get(i).getReserve();
            if(courses.get(i).getEndtime()!=null) {
                out.setEndtime(dateFormat.format(courses.get(i).getEndtime()));
            }
            if(courses.get(i).getStarttime()!=null) {
                out.setStarttime(dateFormat.format(courses.get(i).getStarttime()));
            }
            out.setCoursename(coursename);
            out.setCourseid(courseid);
            out.setCoachid(coachid);
            out.setReserve(reserve);
            out.setNumLimit(numByCourseId+"/"+numLimit);
            if(numByCourseId>=numLimit){
                out.setLimitflag("上课人数已达上限");
            }else {
                out.setLimitflag("");
            }
            CourseOut.add(out);
        }
        return CourseOut;
    }

//    @Override
//    public int editCourse(Course course) {
//        int i = courseMapper.updateByPrimaryKey(course);
//        return i;
//    }
}
