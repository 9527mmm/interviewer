package com.zxk.domain.store;

import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @program: interviewer
 * @description: 题目实体类
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 21:09
 **/
public class Question implements Serializable {
    private static final long serialVersionUID = 362498820763181265L;
    /**
     * 题目id
     */
    @ExcelProperty("题目ID")
    private String id;
    /**
     * 题目所属企业id
     */
    @ExcelProperty("所属公司ID")
    private String companyId;
    /**
     * 题目所属目录id
     */
    @ExcelProperty("所属目录ID")
    private String catalogId;
    /**
     * 题目简介/题目描述
     */
    @ExcelProperty("题目简介")
    private String remark;
    /**
     * 题干正文
     */
    @ExcelProperty("题干描述")
    private String subject;
    /**
     * 图片
     */
    @ExcelProperty("题干配图")
    private String picture;
    /**
     * 题目分析
     */
    @ExcelProperty("题目分析")
    private String analysis;
    /**
     * 题目类型，1单选，2多选，3简答
     */
    @ExcelProperty("题目类型")
    private String type;
    /**
     * 难度，1极易，2容易，3普通，4困难，5极难
     */
    @ExcelProperty("题目难度")
    private String difficulty;
    /**
     * 是否经典面试题 0：否，1：是
     */
    @ExcelProperty("是否经典题")
    private String isClassic;
    /**
     * 题目状态，0：不可用，1：可用 （只有审核通过的题目才可以设置）
     */
    @ExcelProperty("题目状态")
    private String state;
    /**
     * 审核状态 -1：审核不通过，0：审核中，1：审核通过
     */
    @ExcelProperty("审核状态")
    private String reviewStatus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

    private Company company;
    private Catalog catalog;

    public Question() {
    }

    public Question(String id, String companyId, String catalogId, String remark, String subject, String analysis,
                    String type, String difficulty, String isClassic, String state, String reviewStatus,
                    Date createTime, Company company, Catalog catalog,Date updateTime) {
        this.id = id;
        this.companyId = companyId;
        this.catalogId = catalogId;
        this.remark = remark;
        this.subject = subject;
        this.analysis = analysis;
        this.type = type;
        this.difficulty = difficulty;
        this.isClassic = isClassic;
        this.state = state;
        this.reviewStatus = reviewStatus;
        this.createTime = createTime;
        this.company = company;
        this.catalog = catalog;
        this.updateTime=updateTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getIsClassic() {
        return isClassic;
    }

    public void setIsClassic(String isClassic) {
        this.isClassic = isClassic;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Question question = (Question) o;
        return Objects.equals(getId(), question.getId()) &&
                Objects.equals(getCompanyId(), question.getCompanyId()) &&
                Objects.equals(getCatalogId(), question.getCatalogId()) &&
                Objects.equals(getRemark(), question.getRemark()) &&
                Objects.equals(getSubject(), question.getSubject()) &&
                Objects.equals(getPicture(), question.getPicture()) &&
                Objects.equals(getAnalysis(), question.getAnalysis()) &&
                Objects.equals(getType(), question.getType()) &&
                Objects.equals(getDifficulty(), question.getDifficulty()) &&
                Objects.equals(getIsClassic(), question.getIsClassic()) &&
                Objects.equals(getState(), question.getState()) &&
                Objects.equals(getReviewStatus(), question.getReviewStatus()) &&
                Objects.equals(getCreateTime(), question.getCreateTime()) &&
                Objects.equals(getUpdateTime(), question.getUpdateTime()) &&
                Objects.equals(getCompany(), question.getCompany()) &&
                Objects.equals(getCatalog(), question.getCatalog());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCompanyId(), getCatalogId(), getRemark(), getSubject(), getPicture(), getAnalysis(), getType(), getDifficulty(), getIsClassic(), getState(), getReviewStatus(), getCreateTime(), getUpdateTime(), getCompany(), getCatalog());
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", companyId='" + companyId + '\'' +
                ", catalogId='" + catalogId + '\'' +
                ", remark='" + remark + '\'' +
                ", subject='" + subject + '\'' +
                ", picture='" + picture + '\'' +
                ", analysis='" + analysis + '\'' +
                ", type='" + type + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", isClassic='" + isClassic + '\'' +
                ", state='" + state + '\'' +
                ", reviewStatus='" + reviewStatus + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", company=" + company +
                ", catalog=" + catalog +
                '}';
    }
}
