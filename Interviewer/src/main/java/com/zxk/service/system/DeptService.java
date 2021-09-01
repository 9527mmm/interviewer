package com.zxk.service.system;

import com.github.pagehelper.PageInfo;
import com.zxk.domain.system.Dept;

import java.util.List;

/**
 * @program: interviewer
 * @description: dept业务层
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:35
 **/
public interface DeptService {
    /**
     * 查询全部
     * @return dept集合
     */
    List<Dept> findAll();

    /**
     * 通过id查询
     *
     * @param id 主键id
     * @return dept对象
     */
    Dept findById(String id);

    /**
     * 通过主键id删除
     * @param
     * @return 影响行数
     */
    void delete(Dept dept);

    /**
     * 添加
     * @param dept 新增的dept对象
     * @return 影响行数
     */
    void save(Dept dept);

    /**
     * 修改
     * @param dept 修改的dept对象
     * @return 影响行数
     */
    void update(Dept dept);

    /**
     * 分页查询全部
     * @param page 页码
     * @param size 每页显示总数
     * @return PageInfo
     */
    PageInfo findAll(int page,int size);
}
