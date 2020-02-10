package com.kb.c_s_system.web;

import com.kb.c_s_system.bean.Course;
import com.kb.c_s_system.bean.extend.CourseOut;
import com.kb.c_s_system.service.Impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class courseController {

    @Autowired
    private CourseServiceImpl courseService;

    @ResponseBody
    @GetMapping("/deleteByCourseId")
    public void deleteByCourseId(int id){
        int i = courseService.deleteByCourseId(id);
    }

    @ResponseBody
    @GetMapping("/findAllCourse")
    public List<CourseOut> findAllCourse(){

        List<CourseOut> allCourse = courseService.findAllCourse();
        return allCourse;
    }


}
