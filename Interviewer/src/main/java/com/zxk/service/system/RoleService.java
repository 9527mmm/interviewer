package com.zxk.service.system;

import com.github.pagehelper.PageInfo;
import com.zxk.domain.system.Role;

import java.util.List;

/**
 * @program: interviewer
 * @description: role业务层
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:35
 **/
public interface RoleService {
    /**
     * 查询全部
     * @return role集合
     */
    List<Role> findAll();

    /**
     * 通过id查询
     *
     * @param id 主键id
     * @return role对象
     */
    Role findById(String id);

    /**
     * 通过主键id删除
     * @param
     * @return 影响行数
     */
    void delete(Role role);

    /**
     * 添加
     * @param role 新增的role对象
     * @return 影响行数
     */
    void save(Role role);

    /**
     * 修改
     * @param role 修改的role对象
     * @return 影响行数
     */
    void update(Role role);

    /**
     * 分页查询全部
     * @param page 页码
     * @param size 每页显示总数
     * @return PageInfo
     */
    PageInfo findAll(int page,int size);

    void updateRoleModule(String roleId, String moduleIds);

    List<Role> findUserRoleByUID(String uid);

    void updateUserRoleByUID(String uid, String[] roleIds);
}
