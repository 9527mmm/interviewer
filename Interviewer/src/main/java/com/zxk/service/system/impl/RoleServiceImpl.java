package com.zxk.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxk.domain.system.Role;
import com.zxk.mapper.system.RoleMapper;
import com.zxk.service.system.RoleService;
import com.zxk.utils.MapperUtil;
import com.zxk.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:43
 **/
public class RoleServiceImpl implements RoleService {
    @Override
    public List<Role> findAll() {
        try {
            RoleMapper mapper = MapperUtil.getMapper(RoleMapper.class);
            List<Role> all = mapper.findAll();
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
    public Role findById(String id) {
        try {
            RoleMapper mapper = MapperUtil.getMapper(RoleMapper.class);
            Role role = mapper.findById(id);
            MapperUtil.commit();
            return role;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
        return null;
    }

    @Override
    public void delete(Role role) {
        try {
            RoleMapper mapper = MapperUtil.getMapper(RoleMapper.class);
            Integer i = mapper.delete(role.getId());
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public void save(Role role) {
        try {
            RoleMapper mapper = MapperUtil.getMapper(RoleMapper.class);
            String id = UUIDUtil.getUUID32();
            role.setId(id);
            Integer i = mapper.save(role);
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public void update(Role role) {
        try {
            RoleMapper mapper = MapperUtil.getMapper(RoleMapper.class);
            Integer i = mapper.update(role);
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
            RoleMapper mapper = MapperUtil.getMapper(RoleMapper.class);
            PageHelper.startPage(page, size);
            List<Role> all = mapper.findAll();
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
    public void updateRoleModule(String roleId, String moduleIds) {
        try {
            RoleMapper mapper = MapperUtil.getMapper(RoleMapper.class);
            mapper.deleteRoleModule(roleId);
            String[] split = moduleIds.split(",");
            for (String moduleId: split) {
                if(StringUtils.isNotBlank(moduleId)){
                    mapper.saveRoleModule(roleId,moduleId);
                }
            }
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public List<Role> findUserRoleByUID(String uid) {
        try {
            RoleMapper mapper = MapperUtil.getMapper(RoleMapper.class);
            List<Role> all=mapper.findUserRoleByUID(uid);
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
    public void updateUserRoleByUID(String uid, String[] roleIds) {
        try {
            RoleMapper mapper = MapperUtil.getMapper(RoleMapper.class);
            Integer i=mapper.deleteUserRoleByUID(uid);
            if(roleIds!=null){
                for (String roleId : roleIds) {
                    mapper.saveRoleUser(uid,roleId);
                }
            }

            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }


    }
}
