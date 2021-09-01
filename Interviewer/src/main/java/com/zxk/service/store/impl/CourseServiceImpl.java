package com.zxk.service.store.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxk.domain.store.Course;
import com.zxk.mapper.store.CourseMapper;
import com.zxk.service.store.CourseService;
import com.zxk.utils.MapperUtil;
import com.zxk.utils.UUIDUtil;

import java.util.Date;
import java.util.List;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:43
 **/
public class CourseServiceImpl implements CourseService {
    @Override
    public List<Course> findAll() {
        try {
            CourseMapper mapper = MapperUtil.getMapper(CourseMapper.class);
            List<Course> all = mapper.findAll();
            MapperUtil.commit();
            return all;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
        return null;
    }

    @Override
    public Course findById(String id) {
        try {
            CourseMapper mapper = MapperUtil.getMapper(CourseMapper.class);
            Course course = mapper.findById(id);
            MapperUtil.commit();
            return course;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
        return null;
    }

    @Override
    public void delete(Course course) {
        try {
            CourseMapper mapper = MapperUtil.getMapper(CourseMapper.class);
            Integer i = mapper.delete(course.getId());
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public void save(Course course) {
        try {
            CourseMapper mapper = MapperUtil.getMapper(CourseMapper.class);
            String id = UUIDUtil.getUUID32();
            course.setId(id);
            course.setCreateTime(new Date());
            Integer i = mapper.save(course);
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public void update(Course course) {
        try {
            CourseMapper mapper = MapperUtil.getMapper(CourseMapper.class);
            Integer i = mapper.update(course);
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public PageInfo findAll(int page, int size) {
        try {
            CourseMapper mapper = MapperUtil.getMapper(CourseMapper.class);
            PageHelper.startPage(page, size);
            List<Course> all = mapper.findAll();
            MapperUtil.commit();
            return new PageInfo(all);
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
        return null;
    }
}
