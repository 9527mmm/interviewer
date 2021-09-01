package com.zxk.domain.system;

import java.io.Serializable;
import java.util.Objects;

/**
 * @program: interviewer
 * @description: 部门类
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 15:56
 **/
public class Dept implements Serializable {
    private static final long serialVersionUID = 362498820763181265L;
    /**
     * 主键id
     */
    private String id;
    /**
     * 部门名称
     */
    private String deptName;
    private String parentId;
    private Integer state;

    private Dept parent;
    public Dept() {
    }

    public Dept(String id, String deptName, String parentId, Integer state, Dept parent) {
        this.id = id;
        this.deptName = deptName;
        this.parentId = parentId;
        this.state = state;
        this.parent = parent;
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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Dept getParent() {
        return parent;
    }

    public void setParent(Dept parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dept dept = (Dept) o;
        return Objects.equals(getId(), dept.getId()) &&
                Objects.equals(getDeptName(), dept.getDeptName()) &&
                Objects.equals(getParentId(), dept.getParentId()) &&
                Objects.equals(getState(), dept.getState()) &&
                Objects.equals(getParent(), dept.getParent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDeptName(), getParentId(), getState(), getParent());
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id='" + id + '\'' +
                ", deptName='" + deptName + '\'' +
                ", parentId='" + parentId + '\'' +
                ", state=" + state +
                ", parent=" + parent +
                '}';
    }
}
