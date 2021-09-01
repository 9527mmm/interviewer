package com.zxk.mapper.store;

import com.zxk.domain.store.Catalog;

import java.util.List;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:23
 **/
public interface CatalogMapper {
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
     * 通过主键id删除
     * @param id 主键id
     * @return 影响行数
     */
    Integer delete(String id);

    /**
     * 添加
     * @param catalog 新增的catalog对象
     * @return 影响行数
     */
    Integer save(Catalog catalog);

    /**
     * 修改
     * @param catalog 修改的catalog对象
     * @return 影响行数
     */
    Integer update(Catalog catalog);
}
