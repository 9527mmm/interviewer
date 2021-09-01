package com.zxk.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxk.domain.system.Dept;
import com.zxk.mapper.system.DeptMapper;
import com.zxk.service.system.DeptService;
import com.zxk.utils.MapperUtil;
import com.zxk.utils.UUIDUtil;

import java.util.List;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:43
 **/
public class DeptServiceImpl implements DeptService {
    @Override
    public List<Dept> findAll() {
        try {
            DeptMapper mapper = MapperUtil.getMapper(DeptMapper.class);
            List<Dept> all = mapper.findAll();
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
    public Dept findById(String id) {
        try {
            DeptMapper mapper = MapperUtil.getMapper(DeptMapper.class);
            Dept dept = mapper.findById(id);
            MapperUtil.commit();
            return dept;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
        return null;
    }

    @Override
    public void delete(Dept dept) {
        try {
            DeptMapper mapper = MapperUtil.getMapper(DeptMapper.class);
            Integer i = mapper.delete(dept.getId());
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public void save(Dept dept) {
        try {
            DeptMapper mapper = MapperUtil.getMapper(DeptMapper.class);
            String id = UUIDUtil.getUUID32();
            dept.setId(id);
            Integer i = mapper.save(dept);
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public void update(Dept dept) {
        try {
            DeptMapper mapper = MapperUtil.getMapper(DeptMapper.class);
            Integer i = mapper.update(dept);
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
            DeptMapper mapper = MapperUtil.getMapper(DeptMapper.class);
            PageHelper.startPage(page, size);
            List<Dept> all = mapper.findAll();
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
