package com.zxk.service.store;

import com.github.pagehelper.PageInfo;
import com.zxk.domain.store.Question;

import javax.servlet.ServletOutputStream;
import java.util.List;

/**
 * @program: interviewer
 * @description: question业务层
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:35
 **/
public interface QuestionService {
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
     * 删除
     * @param question
     */
    void delete(Question question);

    /**
     * 添加
     * @param question 新增的question对象
     * @return 影响行数
     */
    void save(Question question);

    /**
     * 修改
     * @param question 修改的question对象
     * @return 影响行数
     */
    void update(Question question);

    /**
     * 分页查询全部
     * @param page 页码
     * @param size 每页显示总数
     * @return PageInfo
     */
    PageInfo findAll(int page,int size);

    void toExport(String templatePath, ServletOutputStream outputStream);

    void toExport2(String templatePath, ServletOutputStream outputStream);

    void upload(String excelPath);
}
