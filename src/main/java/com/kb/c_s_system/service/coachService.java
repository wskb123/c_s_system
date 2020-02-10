package com.kb.c_s_system.service;

import com.kb.c_s_system.bean.Coach;
import com.kb.c_s_system.bean.Course;
import com.kb.c_s_system.bean.extend.CourseOut;

import java.util.List;

public interface coachService {
            List<CourseOut> findAllCourseByCoachId(int id); //查找本教练的所有课程
            List<Coach>   findAllCoach();    //查找所有的教练
            void insertOrUpdateCourse(Course course);
            //删除操作都在manager（经理） controller中操作，这里没有权限，但是实现在这里完成！
            int deleteByCoachId(int id);
            Coach findCoachUserByIdAndPw(String userID,String password);
            void insertOrUpdateCoach(Coach coach);
            Coach findCoachById(int id);
}
