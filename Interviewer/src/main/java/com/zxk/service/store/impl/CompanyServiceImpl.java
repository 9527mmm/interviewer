package com.zxk.service.store.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxk.domain.store.Company;
import com.zxk.mapper.store.CompanyMapper;
import com.zxk.service.store.CompanyService;
import com.zxk.utils.MapperUtil;
import com.zxk.utils.UUIDUtil;

import java.util.List;
import java.util.UUID;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:43
 **/
public class CompanyServiceImpl implements CompanyService {
    @Override
    public List<Company> findAll() {
        try {
            CompanyMapper mapper = MapperUtil.getMapper(CompanyMapper.class);
            List<Company> all = mapper.findAll();
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
    public Company findById(String id) {
        try {
            CompanyMapper mapper = MapperUtil.getMapper(CompanyMapper.class);
            Company company = mapper.findById(id);
            MapperUtil.commit();
            return company;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
        return null;
    }

    @Override
    public void delete(Company company) {
        try {
            CompanyMapper mapper = MapperUtil.getMapper(CompanyMapper.class);
            Integer i = mapper.delete(company.getId());
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public void save(Company company) {
        try {
            CompanyMapper mapper = MapperUtil.getMapper(CompanyMapper.class);
            String id = UUIDUtil.getUUID32();
            company.setId(id);
            Integer i = mapper.save(company);
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public void update(Company company) {
        try {
            CompanyMapper mapper = MapperUtil.getMapper(CompanyMapper.class);
            Integer i = mapper.update(company);
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
            CompanyMapper mapper = MapperUtil.getMapper(CompanyMapper.class);
            PageHelper.startPage(page, size);
            List<Company> all = mapper.findAll();
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
