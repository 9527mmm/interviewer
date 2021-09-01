package com.zxk.mapper.store;

import com.zxk.domain.store.Course;

import java.util.List;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:23
 **/
public interface CourseMapper {
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
     * 通过主键id删除
     * @param id 主键id
     * @return 影响行数
     */
    Integer delete(String id);

    /**
     * 添加
     * @param course 新增的course对象
     * @return 影响行数
     */
    Integer save(Course course);

    /**
     * 修改
     * @param course 修改的course对象
     * @return 影响行数
     */
    Integer update(Course course);
}
