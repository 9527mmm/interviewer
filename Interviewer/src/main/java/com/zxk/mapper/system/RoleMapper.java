package com.zxk.mapper.system;

import com.zxk.domain.system.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:23
 **/
public interface RoleMapper {
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
     * @param id 主键id
     * @return 影响行数
     */
    Integer delete(String id);

    /**
     * 添加
     * @param role 新增的role对象
     * @return 影响行数
     */
    Integer save(Role role);

    /**
     * 修改
     * @param role 修改的role对象
     * @return 影响行数
     */
    Integer update(Role role);

    /**
     * 删除ss_role_moudle表中的所有与此roleId有关信息
     * @param roleId
     */
    void deleteRoleModule(String roleId);

    /**
     * 添加role和moudle的关系
     * @param roleId
     * @param moduleId
     */
    void saveRoleModule(@Param("roleId") String roleId,@Param("moduleId") String moduleId);

    List<Role> findUserRoleByUID(String uid);

    Integer deleteUserRoleByUID(String uid);

    void saveRoleUser( @Param("user_id") String uid,@Param("role_id") String roleId);
}
