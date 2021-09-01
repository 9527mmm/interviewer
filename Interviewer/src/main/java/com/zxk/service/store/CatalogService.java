package com.zxk.service.store;

import com.github.pagehelper.PageInfo;
import com.zxk.domain.store.Catalog;

import java.util.List;

/**
 * @program: interviewer
 * @description: catalog业务层
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:35
 **/
public interface CatalogService {
    /**
     * 查询全部
     * @return catalog集合
     */
    List<Catalog> findAll();

    /**
     * 通过id查询
     *
     * @param id 主键id
     * @return catalog对象
     */
    Catalog findById(String id);

    /**
     * 删除
     * @param catalog
     */
    void delete(Catalog catalog);

    /**
     * 添加
     * @param catalog 新增的catalog对象
     * @return 影响行数
     */
    void save(Catalog catalog);

    /**
     * 修改
     * @param catalog 修改的catalog对象
     * @return 影响行数
     */
    void update(Catalog catalog);

    /**
     * 分页查询全部
     * @param page 页码
     * @param size 每页显示总数
     * @return PageInfo
     */
    PageInfo findAll(int page,int size);
}
