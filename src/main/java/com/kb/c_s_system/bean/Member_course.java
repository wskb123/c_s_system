package com.kb.c_s_system.bean;

public class Member_course {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member_course.id
     *
     * @mbg.generated Fri Nov 15 14:35:01 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member_course.cardId
     *
     * @mbg.generated Fri Nov 15 14:35:01 CST 2019
     */
    private Integer cardid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member_course.courseId
     *
     * @mbg.generated Fri Nov 15 14:35:01 CST 2019
     */
    private Integer courseid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member_course.signFlag
     *
     * @mbg.generated Fri Nov 15 14:35:01 CST 2019
     */
    private String signflag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member_course.reserve
     *
     * @mbg.generated Fri Nov 15 14:35:01 CST 2019
     */
    private String reserve;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member_course.id
     *
     * @return the value of member_course.id
     *
     * @mbg.generated Fri Nov 15 14:35:01 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member_course.id
     *
     * @param id the value for member_course.id
     *
     * @mbg.generated Fri Nov 15 14:35:01 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member_course.cardId
     *
     * @return the value of member_course.cardId
     *
     * @mbg.generated Fri Nov 15 14:35:01 CST 2019
     */
    public Integer getCardid() {
        return cardid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member_course.cardId
     *
     * @param cardid the value for member_course.cardId
     *
     * @mbg.generated Fri Nov 15 14:35:01 CST 2019
     */
    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member_course.courseId
     *
     * @return the value of member_course.courseId
     *
     * @mbg.generated Fri Nov 15 14:35:01 CST 2019
     */
    public Integer getCourseid() {
        return courseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member_course.courseId
     *
     * @param courseid the value for member_course.courseId
     *
     * @mbg.generated Fri Nov 15 14:35:01 CST 2019
     */
    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member_course.signFlag
     *
     * @return the value of member_course.signFlag
     *
     * @mbg.generated Fri Nov 15 14:35:01 CST 2019
     */
    public String getSignflag() {
        return signflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member_course.signFlag
     *
     * @param signflag the value for member_course.signFlag
     *
     * @mbg.generated Fri Nov 15 14:35:01 CST 2019
     */
    public void setSignflag(String signflag) {
        this.signflag = signflag == null ? null : signflag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member_course.reserve
     *
     * @return the value of member_course.reserve
     *
     * @mbg.generated Fri Nov 15 14:35:01 CST 2019
     */
    public String getReserve() {
        return reserve;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member_course.reserve
     *
     * @param reserve the value for member_course.reserve
     *
     * @mbg.generated Fri Nov 15 14:35:01 CST 2019
     */
    public void setReserve(String reserve) {
        this.reserve = reserve == null ? null : reserve.trim();
    }
}