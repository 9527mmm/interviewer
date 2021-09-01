package com.zxk.mapper.system;


import com.zxk.domain.system.Dept;

import java.util.List;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:23
 **/
public interface DeptMapper {
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
     * @param id 主键id
     * @return 影响行数
     */
    Integer delete(String id);

    /**
     * 添加
     * @param dept 新增的dept对象
     * @return 影响行数
     */
    Integer save(Dept dept);

    /**
     * 修改
     * @param dept 修改的dept对象
     * @return 影响行数
     */
    Integer update(Dept dept);
}
