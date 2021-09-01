package com.zxk.service.system;

import com.github.pagehelper.PageInfo;
import com.zxk.domain.system.Module;

import java.util.List;
import java.util.Map;

/**
 * @program: interviewer
 * @description: role业务层
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:35
 **/
public interface ModuleService {
    /**
     * 查询全部
     * @return Module
     */
    List<Module> findAll();

    /**
     * 通过id查询
     *
     * @param id 主键id
     * @return
     */
    Module findById(String id);

    /**
     * 通过主键id删除
     * @param
     * @return 影响行数
     */
    void delete(Module module);

    /**
     * 添加
     * @param module
     * @return 影响行数
     */
    void save(Module module);

    /**
     * 修改
     * @param module
     * @return 影响行数
     */
    void update(Module module);

    /**
     * 分页查询全部
     * @param page 页码
     * @param size 每页显示总数
     * @return PageInfo
     */
    PageInfo findAll(int page,int size);

    List<Map> findAuthorDataByRoleID(String roleId);

    List<Module> findModuleByUid(String uid);
}
