package com.kb.c_s_system.web;

import com.kb.c_s_system.bean.Coach;
import com.kb.c_s_system.bean.Course;
import com.kb.c_s_system.bean.extend.CourseOut;
import com.kb.c_s_system.service.Impl.coachServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class coachController {
    @Autowired
    private coachServiceImpl coachServiceImpl;

    @ResponseBody
    @GetMapping("/findAllCourseByCoachId")
    public  List<CourseOut>  findAllCourse(int id){
//        System.out.println("进入findAllCourse了");

        List<CourseOut> CourseOut = coachServiceImpl.findAllCourseByCoachId(id);
        return CourseOut;
    }

 /*   @ResponseBody
    @GetMapping("/findAll")
    public  List<Coach>  findAll(){
//        System.out.println("进入findAll了");

        List<Coach> coachs = coachServiceImpl.findAllCoach();
        return coachs;
    }*/

    @ResponseBody
    @PostMapping("insertOrUpdateCourse")
    public void insertOrUpdateCourse(Course course){
        coachServiceImpl.insertOrUpdateCourse(course);
    }
    @ResponseBody
    @PostMapping("/insertOrUpdateCoach")
    private void insertOrUpdateCoach(Coach coach){
        coachServiceImpl.insertOrUpdateCoach(coach);
    }
}
