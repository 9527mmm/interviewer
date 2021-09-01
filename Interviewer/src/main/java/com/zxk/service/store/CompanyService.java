package com.zxk.service.store;

import com.github.pagehelper.PageInfo;
import com.zxk.domain.store.Company;

import java.util.List;

/**
 * @program: interviewer
 * @description: company业务层
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:35
 **/
public interface CompanyService {
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
    void delete(Company company);

    /**
     * 添加
     * @param company 新增的company对象
     * @return 影响行数
     */
    void save(Company company);

    /**
     * 修改
     * @param company 修改的company对象
     * @return 影响行数
     */
    void update(Company company);

    /**
     * 分页查询全部
     * @param page 页码
     * @param size 每页显示总数
     * @return PageInfo
     */
    PageInfo findAll(int page,int size);
}
