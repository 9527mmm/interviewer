package com.zxk.mapper.system;

import com.zxk.domain.system.Role;
import com.zxk.domain.system.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:23
 **/
public interface UserMapper {
    /**
     * 查询全部
     * @return dept集合
     */
    List<User> findAll();

    /**
     * 通过id查询
     *
     * @param id 主键id
     * @return dept对象
     */
    User findById(String id);

    /**
     * 通过主键id删除
     * @param id 主键id
     * @return 影响行数
     */
    Integer delete(String id);

    /**
     * 添加
     * @param user 新增的dept对象
     * @return 影响行数
     */
    Integer save(User user);

    /**
     * 修改
     * @param user 修改的dept对象
     * @return 影响行数
     */
    Integer update(User user);


    User findByEandP(@Param("email") String email,@Param("password") String password);
}
