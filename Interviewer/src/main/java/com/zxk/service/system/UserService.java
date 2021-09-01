package com.zxk.service.system;

import com.github.pagehelper.PageInfo;
import com.zxk.domain.system.User;

import java.util.List;

/**
 * @program: interviewer
 * @description: dept业务层
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:35
 **/
public interface UserService {
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
     * @param
     * @return 影响行数
     */
    void delete(User user);

    /**
     * 添加
     * @param user 新增的dept对象
     * @return 影响行数
     */
    void save(User user);

    /**
     * 修改
     * @param user 修改的dept对象
     * @return 影响行数
     */
    void update(User user);

    /**
     * 分页查询全部
     * @param page 页码
     * @param size 每页显示总数
     * @return PageInfo
     */
    PageInfo findAll(int page,int size);

    User login(String email, String password);
}
