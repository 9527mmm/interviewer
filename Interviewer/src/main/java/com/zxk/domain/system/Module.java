package com.zxk.domain.system;

import java.io.Serializable;
import java.util.Objects;

/**
 * @program: interviewer
 * @description: 模块实体类
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-29 19:05
 **/
public class Module implements Serializable {
    private static final long serialVersionUID = 362498820763181265L;
    /**
     * 主键id
     */
    private String id;
    /**
     * 所属模块id
     */
    private  String parentId;
    /**
     * 名称
     */
    private String name;
    /**
     * 类型（1-系统菜单，2-二级菜单，3-....4...）
     */
    private String cType;
    /**
     * 状态（1-可用，2-不可用）
     */
    private String state;
    /**
     * 请求url（用于权限校验）
     */
    private String curl;
    /**
     * 描述
     */
    private String remark;
    /**
     * 自连接关系
     */
    private Module module;

    public Module() {
    }

    public Module(String id, String parentId, String name, String cType, String state, String curl, String remark,
                  Module module) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.cType = cType;
        this.state = state;
        this.curl = curl;
        this.remark = remark;
        this.module = module;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Module module1 = (Module) o;
        return Objects.equals(getId(), module1.getId()) &&
                Objects.equals(getParentId(), module1.getParentId()) &&
                Objects.equals(getName(), module1.getName()) &&
                Objects.equals(getcType(), module1.getcType()) &&
                Objects.equals(getState(), module1.getState()) &&
                Objects.equals(getCurl(), module1.getCurl()) &&
                Objects.equals(getRemark(), module1.getRemark()) &&
                Objects.equals(getModule(), module1.getModule());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getParentId(), getName(), getcType(), getState(), getCurl(), getRemark(), getModule());
    }

    @Override
    public String toString() {
        return "Module{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", name='" + name + '\'' +
                ", cType='" + cType + '\'' +
                ", state='" + state + '\'' +
                ", curl='" + curl + '\'' +
                ", remark='" + remark + '\'' +
                ", module=" + module +
                '}';
    }
}
