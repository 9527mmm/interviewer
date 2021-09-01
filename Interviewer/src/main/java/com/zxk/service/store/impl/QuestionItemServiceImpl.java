package com.zxk.service.store.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxk.domain.store.QuestionItem;
import com.zxk.mapper.store.QuestionItemMapper;
import com.zxk.service.store.QuestionItemService;
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
public class QuestionItemServiceImpl implements QuestionItemService {
    @Override
    public QuestionItem findById(String id) {
        try {
            QuestionItemMapper mapper = MapperUtil.getMapper(QuestionItemMapper.class);
            QuestionItem questionItem = mapper.findById(id);
            MapperUtil.commit();
            return questionItem;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
        return null;
    }

    @Override
    public PageInfo findAll(String questionId, int page, int size) {
        try {
            QuestionItemMapper mapper = MapperUtil.getMapper(QuestionItemMapper.class);
            PageHelper.startPage(page, size);
            List<QuestionItem> all = mapper.findAll(questionId);
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
    public void delete(QuestionItem questionItem) {
        try {
            QuestionItemMapper mapper = MapperUtil.getMapper(QuestionItemMapper.class);
            Integer i = mapper.delete(questionItem.getId());
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public void save(QuestionItem questionItem) {
        try {
            QuestionItemMapper mapper = MapperUtil.getMapper(QuestionItemMapper.class);
            String id = UUIDUtil.getUUID32();
            questionItem.setId(id);
            Integer i = mapper.save(questionItem);
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public void update(QuestionItem questionItem) {
        try {
            QuestionItemMapper mapper = MapperUtil.getMapper(QuestionItemMapper.class);
            Integer i = mapper.update(questionItem);
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }
}
