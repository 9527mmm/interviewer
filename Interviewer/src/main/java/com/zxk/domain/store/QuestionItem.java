package com.zxk.domain.store;

import java.io.Serializable;
import java.util.Objects;

/**
 * @program: interviewer
 * @description: 问题选项实体类
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-29 17:14
 **/
public class QuestionItem implements Serializable {
    private static final long serialVersionUID = 362498820763181265L;
    /**
     * 主键id
     */
    private String id;
    /**
     * 题目id
     */
    private String questionId;
    /**
     * 选项内容
     */
    private String content;
    /**
     * 选项图片
     */
    private String picture;
    /**
     * 是否正确答案
     */
    private String isRight;

    public QuestionItem() {
    }

    public QuestionItem(String id, String questionId, String content, String picture, String isRight) {
        this.id = id;
        this.questionId = questionId;
        this.content = content;
        this.picture = picture;
        this.isRight = isRight;
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

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIsRight() {
        return isRight;
    }

    public void setIsRight(String isRight) {
        this.isRight = isRight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        QuestionItem that = (QuestionItem) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getQuestionId(), that.getQuestionId()) &&
                Objects.equals(getContent(), that.getContent()) &&
                Objects.equals(getPicture(), that.getPicture()) &&
                Objects.equals(getIsRight(), that.getIsRight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getQuestionId(), getContent(), getPicture(), getIsRight());
    }

    @Override
    public String toString() {
        return "QuestionItem{" +
                "id='" + id + '\'' +
                ", questionId='" + questionId + '\'' +
                ", content='" + content + '\'' +
                ", picture='" + picture + '\'' +
                ", isRight='" + isRight + '\'' +
                '}';
    }
}
