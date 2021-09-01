package com.zxk.service.store.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxk.domain.store.Catalog;
import com.zxk.mapper.store.CatalogMapper;
import com.zxk.service.store.CatalogService;
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
public class CatalogServiceImpl implements CatalogService {
    @Override
    public List<Catalog> findAll() {
        try {
            CatalogMapper mapper = MapperUtil.getMapper(CatalogMapper.class);
            List<Catalog> all = mapper.findAll();
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
    public Catalog findById(String id) {
        try {
            CatalogMapper mapper = MapperUtil.getMapper(CatalogMapper.class);
            Catalog catalog = mapper.findById(id);
            MapperUtil.commit();
            return catalog;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
        return null;
    }

    @Override
    public void delete(Catalog catalog) {
        try {
            CatalogMapper mapper = MapperUtil.getMapper(CatalogMapper.class);
            Integer i = mapper.delete(catalog.getId());
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public void save(Catalog catalog) {
        try {
            CatalogMapper mapper = MapperUtil.getMapper(CatalogMapper.class);
            String id = UUIDUtil.getUUID32();
            catalog.setId(id);
            catalog.setCreateTime(new Date());
            Integer i = mapper.save(catalog);
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public void update(Catalog catalog) {
        try {
            CatalogMapper mapper = MapperUtil.getMapper(CatalogMapper.class);
            Integer i = mapper.update(catalog);
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
            CatalogMapper mapper = MapperUtil.getMapper(CatalogMapper.class);
            PageHelper.startPage(page, size);
            List<Catalog> all = mapper.findAll();
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
