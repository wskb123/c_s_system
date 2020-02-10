package com.kb.c_s_system.bean.extend;

import com.kb.c_s_system.bean.Coach;
import com.kb.c_s_system.bean.Course;

import java.util.List;

public class CoachExtend extends Coach {
    private List<Course>  courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
