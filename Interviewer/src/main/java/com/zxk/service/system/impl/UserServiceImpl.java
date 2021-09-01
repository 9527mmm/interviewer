package com.zxk.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxk.domain.system.User;
import com.zxk.mapper.system.UserMapper;
import com.zxk.service.system.UserService;
import com.zxk.utils.MD5Util;
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
public class UserServiceImpl implements UserService {
    @Override
    public List<User> findAll() {
        try {
            UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
            List<User> all = mapper.findAll();
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
    public User findById(String id) {
        try {
            UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
            User user = mapper.findById(id);
            MapperUtil.commit();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
        return null;
    }

    @Override
    public void delete(User user) {
        try {
            UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
            Integer i = mapper.delete(user.getId());
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public void save(User user) {
        try {
            UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
            String id = UUIDUtil.getUUID32();
            user.setId(id);
            user.setPassword(MD5Util.md5(user.getPassword()));
            Integer i = mapper.save(user);
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public void update(User user) {
        try {
            UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
            Integer i = mapper.update(user);
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
            UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
            PageHelper.startPage(page, size);
            List<User> all = mapper.findAll();
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
    public User login(String email, String password) {
        try {
            UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
            password=(MD5Util.md5(password));
            User user=mapper.findByEandP(email,password);
            MapperUtil.commit();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
        return null;
    }
}
