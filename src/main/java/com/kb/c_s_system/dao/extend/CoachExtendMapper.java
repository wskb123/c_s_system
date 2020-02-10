package com.kb.c_s_system.dao.extend;

import com.kb.c_s_system.bean.Course;

import java.util.List;

public interface CoachExtendMapper {
    List<Course>   findAllCourseById(int id);
}
