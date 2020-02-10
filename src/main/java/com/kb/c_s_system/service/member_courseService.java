package com.kb.c_s_system.service;

import com.kb.c_s_system.bean.Member_course;


import java.util.List;

public interface member_courseService {
    String saveOrUpdateMem_Course(Member_course m_c);
    List<Integer> findAllCourseIdByCardId(int cardid);
    Integer  findNumByCourseId(int courseid);   //根据课程id查询上课人数
}
