package com.zxk.domain.system;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @program: interviewer
 * @description: 角色实体类
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-29 19:02
 **/
public class Role implements Serializable {
    private static final long serialVersionUID = 362498820763181265L;
    /**
     * 主键id
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createTime;

    public Role() {
    }

    public Role(String id, String name, String remark, Date createTime) {
        this.id = id;
        this.name = name;
        this.remark = remark;
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
        Role role = (Role) o;
        return Objects.equals(getId(), role.getId()) &&
                Objects.equals(getName(), role.getName()) &&
                Objects.equals(getRemark(), role.getRemark()) &&
                Objects.equals(getCreateTime(), role.getCreateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRemark(), getCreateTime());
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
