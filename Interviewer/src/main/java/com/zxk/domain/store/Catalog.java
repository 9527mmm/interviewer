package com.zxk.domain.store;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @program: interviewer
 * @description: 学科实体类
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 20:34
 **/
public class Catalog implements Serializable {
    private static final long serialVersionUID = 362498820763181265L;
    /**
     * 主键id
     */
    private String id;
    /**
     * 学科名称
     */
    private String name;
    /**
     * 描述
     */
    private String remark;
    /**
     * 状态
     */
    private String state;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 学科id
     */
    private String courseId;

    private String courseName;
    private Course course;

    public Catalog() {
    }

    public Catalog(String id, String name,String courseName, String remark, String state, Date createTime, String courseId, Course course)
    {
        this.id = id;
        this.name = name;
        this.remark = remark;
        this.state = state;
        this.createTime = createTime;
        this.courseId = courseId;
        this.course = course;
        this.courseName=courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Catalog catalog = (Catalog) o;
        return Objects.equals(getId(), catalog.getId()) &&
                Objects.equals(getName(), catalog.getName()) &&
                Objects.equals(getCourseName(), catalog.getCourseName()) &&
                Objects.equals(getRemark(), catalog.getRemark()) &&
                Objects.equals(getState(), catalog.getState()) &&
                Objects.equals(getCreateTime(), catalog.getCreateTime()) &&
                Objects.equals(getCourseId(), catalog.getCourseId()) &&
                Objects.equals(getCourse(), catalog.getCourse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCourseName(),getName(), getRemark(), getState(), getCreateTime(), getCourseId(), getCourse());
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", state='" + state + '\'' +
                ", courseName='" + courseName + '\'' +
                ", createTime=" + createTime +
                ", courseId='" + courseId + '\'' +
                ", course=" + course +
                '}';
    }
}
