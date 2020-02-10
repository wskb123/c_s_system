package com.kb.c_s_system.service;

import com.kb.c_s_system.bean.extend.CourseOut;

import java.util.List;

public interface courseService {
    int deleteByCourseId(int id);
//    int editCourse(Course course);
    List<CourseOut> findAllCourse();
}
