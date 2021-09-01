package com.zxk.service.store.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.SyncReadListener;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxk.domain.store.Question;
import com.zxk.mapper.store.QuestionMapper;
import com.zxk.service.store.QuestionService;
import com.zxk.utils.MapperUtil;
import com.zxk.utils.UUIDUtil;

import javax.servlet.ServletOutputStream;
import java.util.*;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:43
 **/
public class QuestionServiceImpl implements QuestionService {
    @Override
    public List<Question> findAll() {
        try {
            QuestionMapper mapper = MapperUtil.getMapper(QuestionMapper.class);
            List<Question> all = mapper.findAll();
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
    public Question findById(String id) {
        try {
            QuestionMapper mapper = MapperUtil.getMapper(QuestionMapper.class);
            Question question = mapper.findById(id);
            MapperUtil.commit();
            return question;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
        return null;
    }

    @Override
    public void delete(Question question) {
        try {
            QuestionMapper mapper = MapperUtil.getMapper(QuestionMapper.class);
            Integer i = mapper.delete(question.getId());
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public void save(Question question) {
        try {
            QuestionMapper mapper = MapperUtil.getMapper(QuestionMapper.class);
            String id = UUIDUtil.getUUID32();
            question.setId(id);
            question.setCreateTime(new Date());
            question.setReviewStatus("0");
            Integer i = mapper.save(question);
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

    @Override
    public void update(Question question) {
        try {
            QuestionMapper mapper = MapperUtil.getMapper(QuestionMapper.class);
            question.setUpdateTime(new Date());
            Integer i = mapper.update(question);
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
            QuestionMapper mapper = MapperUtil.getMapper(QuestionMapper.class);
            PageHelper.startPage(page, size);
            List<Question> all = mapper.findAll();
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
    public void toExport(String templatePath, ServletOutputStream outputStream) {
        List<Question> all = findAll();
        EasyExcel
                .write(outputStream, Question.class)
                .withTemplate(templatePath)
                .sheet()
                .doFill(all);
    }

    @Override
    public void toExport2(String templatePath, ServletOutputStream outputStream) {
        QuestionMapper mapper = MapperUtil.getMapper(QuestionMapper.class);
        List<Question> all = mapper.findAll();
        MapperUtil.close();
        ExcelWriterBuilder writerBuilder = EasyExcel
                .write(outputStream, Question.class)
                .withTemplate(templatePath);
        ExcelWriter excelWriter = writerBuilder.build();
        WriteSheet writeSheet = writerBuilder.sheet().build();
        FillConfig fillConfig = FillConfig.builder().forceNewRow(true).build();
        excelWriter.fill(all, fillConfig, writeSheet);
        Map<Object, Object> objectObjectMap = new HashMap<>();
        objectObjectMap.put("total", all.size());
        //excelWriter.fill(objectObjectMap, writeSheet);
        excelWriter.finish();

    }

    @Override
    public void upload(String excelPath) {
        final List<Object> list = new ArrayList();
        ;
        EasyExcel
                .read(excelPath, Question.class, new SyncReadListener() {
                    @Override
                    public void invoke(Object object, AnalysisContext context) {
                        list.add(object);
                    }
                }).headRowNumber(2).doReadAll();

        for (Object o : list) {
            Question question = (Question) o;
            save(question);
        }
    }
}
