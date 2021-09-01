package com.zxk.domain.store;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @program: interviewer
 * @description: 学科实体类
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 19:44
 **/
public class Course implements Serializable {
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

    public Course() {
    }

    public Course(String id, String name, String remark, String state, Date createTime) {
        this.id = id;
        this.name = name;
        this.remark = remark;
        this.state = state;
        this.createTime = createTime;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course course = (Course) o;
        return Objects.equals(getId(), course.getId()) &&
                Objects.equals(getName(), course.getName()) &&
                Objects.equals(getRemark(), course.getRemark()) &&
                Objects.equals(getState(), course.getState()) &&
                Objects.equals(getCreateTime(), course.getCreateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRemark(), getState(), getCreateTime());
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", state='" + state + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
