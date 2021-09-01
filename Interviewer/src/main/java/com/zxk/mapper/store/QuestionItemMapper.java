package com.zxk.mapper.store;

import com.zxk.domain.store.QuestionItem;

import java.util.List;

public interface QuestionItemMapper {

    int save(QuestionItem questionItem);

    int delete(String id);

    int update(QuestionItem questionItem);

    QuestionItem findById(String id);

    /**
     * 根据题目id查询所有的选项
     * @param questionId
     * @return
     */
    List<QuestionItem> findAll(String questionId);
}
