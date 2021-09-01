package com.zxk.mapper.system;

import com.zxk.domain.system.Module;

import java.util.List;
import java.util.Map;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:23
 **/
public interface ModuleMapper {
    /**
     * 查询全部
     * @return Module
     */
    List<Module> findAll();

    /**
     * 通过id查询
     *
     * @param id 主键id
     * @return role对象
     */
    Module findById(String id);

    /**
     * 通过主键id删除
     * @param id 主键id
     * @return 影响行数
     */
    Integer delete(String id);

    /**
     * 添加
     * @param module
     * @return 影响行数
     */
    Integer save(Module module);

    /**
     * 修改
     * @param module
     * @return 影响行数
     */
    Integer update(Module module);

    /**
     * 通过roleId查找对应的权限
     * @param roleId
     * @return
     */
    List<Map> findAuthorDataByRoleID(String roleId);

    List<Module> findModuleByUid(String uid);
}
