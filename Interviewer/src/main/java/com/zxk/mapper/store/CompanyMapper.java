package com.zxk.mapper.store;

import com.zxk.domain.store.Company;

import java.util.List;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:23
 **/
public interface CompanyMapper {
    /**
     * 查询全部
     * @return company集合
     */
    List<Company> findAll();

    /**
     * 通过id查询
     *
     * @param id 主键id
     * @return company对象
     */
    Company findById(String id);

    /**
     * 通过主键id删除
     * @param id 主键id
     * @return 影响行数
     */
    Integer delete(String id);

    /**
     * 添加
     * @param company 新增的company对象
     * @return 影响行数
     */
    Integer save(Company company);

    /**
     * 修改
     * @param company 修改的company对象
     * @return 影响行数
     */
    Integer update(Company company);
}
