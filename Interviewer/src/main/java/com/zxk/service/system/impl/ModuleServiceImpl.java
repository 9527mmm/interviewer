package com.zxk.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxk.domain.system.Module;
import com.zxk.mapper.system.ModuleMapper;
import com.zxk.service.system.ModuleService;
import com.zxk.utils.MapperUtil;
import com.zxk.utils.UUIDUtil;

import java.util.List;
import java.util.Map;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:43
 **/
public class ModuleServiceImpl implements ModuleService {
    @Override
    public List<Module> findAll() {
        try {
            ModuleMapper mapper = MapperUtil.getMapper(ModuleMapper.class);
            List<Module> all = mapper.findAll();
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
    public Module findById(String id) {
        try {
            ModuleMapper mapper = MapperUtil.getMapper(ModuleMapper.class);
            Module module = mapper.findById(id);
            MapperUtil.commit();
            return module;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
        return null;
    }

    @Override
    public void delete(Module module) {
        try {
            ModuleMapper mapper = MapperUtil.getMapper(ModuleMapper.class);
            Integer i = mapper.delete(module.getId());
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public void save(Module module) {
        try {
            ModuleMapper mapper = MapperUtil.getMapper(ModuleMapper.class);
            String id = UUIDUtil.getUUID32();
            module.setId(id);
            Integer i = mapper.save(module);
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public void update(Module module) {
        try {
            ModuleMapper mapper = MapperUtil.getMapper(ModuleMapper.class);
            Integer i = mapper.update(module);
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
            ModuleMapper mapper = MapperUtil.getMapper(ModuleMapper.class);
            PageHelper.startPage(page, size);
            List<Module> all = mapper.findAll();
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

    @Override
    public List<Map> findAuthorDataByRoleID(String roleId) {
        try {
            ModuleMapper mapper = MapperUtil.getMapper(ModuleMapper.class);
            List<Map> map = mapper.findAuthorDataByRoleID(roleId);
            MapperUtil.commit();
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
        return null;
    }

    @Override
    public List<Module> findModuleByUid(String uid) {
        try {
            ModuleMapper mapper = MapperUtil.getMapper(ModuleMapper.class);
            List<Module> modules=mapper.findModuleByUid(uid);
            MapperUtil.commit();
            return modules;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
        return null;
    }
}
