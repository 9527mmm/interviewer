package com.zxk.service.store;

import com.github.pagehelper.PageInfo;
import com.zxk.domain.store.Course;

import java.util.List;

/**
 * @program: interviewer
 * @description: course业务层
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:35
 **/
public interface CourseService {
    /**
     * 查询全部
     * @return course集合
     */
    List<Course> findAll();

    /**
     * 通过id查询
     *
     * @param id 主键id
     * @return course对象
     */
    Course findById(String id);

    /**
     * 删除
     * @param course
     */
    void delete(Course course);

    /**
     * 添加
     * @param course 新增的course对象
     * @return 影响行数
     */
    void save(Course course);

    /**
     * 修改
     * @param course 修改的course对象
     * @return 影响行数
     */
    void update(Course course);

    /**
     * 分页查询全部
     * @param page 页码
     * @param size 每页显示总数
     * @return PageInfo
     */
    PageInfo findAll(int page,int size);
}
