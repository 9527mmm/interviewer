package com.zxk.mapper.store;

import com.zxk.domain.store.Question;

import java.util.List;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:23
 **/
public interface QuestionMapper {
    /**
     * 查询全部
     * @return question集合
     */
    List<Question> findAll();

    /**
     * 通过id查询
     *
     * @param id 主键id
     * @return question对象
     */
    Question findById(String id);

    /**
     * 通过主键id删除
     * @param id 主键id
     * @return 影响行数
     */
    Integer delete(String id);

    /**
     * 添加
     * @param question 新增的question对象
     * @return 影响行数
     */
    Integer save(Question question);

    /**
     * 修改
     * @param question 修改的question对象
     * @return 影响行数
     */
    Integer update(Question question);
}
