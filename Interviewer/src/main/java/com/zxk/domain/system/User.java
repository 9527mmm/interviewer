package com.zxk.domain.system;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @program: interviewer
 * @description: 用户实体类
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 18:24
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 362498820763181265L;
    /**
     * 主键id
     */
    private String id;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 姓名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 状态
     */
    private Long state;
    /**
     * 性别
     */
    private String gender;
    /**
     * 电话
     */
    private String telephone;
    /**
     * 出生年月
     */
    private Date birthday;
    /**
     * 入职时间
     */
    private Date joinDate;
    /**
     * 部门id
     */
    private String deptId;
    private String deptName;

    private Dept dept;

    public User() {
    }

    public User(String id, String email, String userName, String password, Long state, String gender, String telephone,
                Date birthday, Date joinDate, String deptId, Dept dept) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.state = state;
        this.gender = gender;
        this.telephone = telephone;
        this.birthday = birthday;
        this.joinDate = joinDate;
        this.deptId = deptId;
        this.dept = dept;
    }

    public User(String id, String email, String userName, String password, Long state, String gender, String telephone,
                Date birthday, Date joinDate, String deptId, String deptName, Dept dept) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.state = state;
        this.gender = gender;
        this.telephone = telephone;
        this.birthday = birthday;
        this.joinDate = joinDate;
        this.deptId = deptId;
        this.deptName = deptName;
        this.dept = dept;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getUserName(), user.getUserName()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getState(), user.getState()) &&
                Objects.equals(getGender(), user.getGender()) &&
                Objects.equals(getTelephone(), user.getTelephone()) &&
                Objects.equals(getBirthday(), user.getBirthday()) &&
                Objects.equals(getJoinDate(), user.getJoinDate()) &&
                Objects.equals(getDeptId(), user.getDeptId()) &&
                Objects.equals(getDept(), user.getDept());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getUserName(), getPassword(), getState(), getGender(), getTelephone(), getBirthday(), getJoinDate(), getDeptId(), getDept());
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                ", gender='" + gender + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birthday=" + birthday +
                ", joinDate=" + joinDate +
                ", deptId='" + deptId + '\'' +
                ", dept=" + dept +
                '}';
    }
}
