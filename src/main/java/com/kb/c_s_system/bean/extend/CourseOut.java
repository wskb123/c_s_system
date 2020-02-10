package com.kb.c_s_system.bean.extend;

import java.io.Serializable;

//用于格式化输出字符
public class CourseOut implements Serializable {
    private Integer courseid;
    private String coursename;
    private String starttime;
    private String endtime;
    private Integer coachid;
    private String reserve;
    private String numLimit;
    //上限标志
    private String limitflag;

    public String getLimitflag() {
        return limitflag;
    }

    public void setLimitflag(String limitflag) {
        this.limitflag = limitflag;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Integer getCoachid() {
        return coachid;
    }

    public void setCoachid(Integer coachid) {
        this.coachid = coachid;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public String getNumLimit() {
        return numLimit;
    }

    public void setNumLimit(String numLimit) {
        this.numLimit = numLimit;
    }

    @Override
    public String toString() {
        return "CourseOut{" +
                "courseid=" + courseid +
                ", coursename='" + coursename + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", coachid=" + coachid +
                ", reserve='" + reserve + '\'' +
                ", numLimit='" + numLimit + '\'' +
                ", limitflag='" + limitflag + '\'' +
                '}';
    }
}
