package com.zxk.web.controller.store;

import com.github.pagehelper.PageInfo;
import com.zxk.domain.store.QuestionItem;
import com.zxk.service.store.QuestionItemService;
import com.zxk.service.store.impl.QuestionItemServiceImpl;
import com.zxk.utils.BeanUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-29 17:33
 **/
@WebServlet("/store/questionItem")
public class QuestionItemServlet extends HttpServlet {
    private QuestionItemService questionItemService = new QuestionItemServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if ("list".equals(operation)) {
            list(req, resp);
        } else if ("saveOrUpdate".equals(operation)) {
            String id = req.getParameter("id");
            if (StringUtils.isBlank(id)) {
                save(req, resp);
            } else {
                update(req, resp);
            }

        } else if ("toEdit".equals(operation)) {
            toEdit(req, resp);
        } else if ("delete".equals(operation)) {
            delete(req, resp);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        QuestionItem questionItem = questionItemService.findById(id);
        questionItemService.delete(questionItem);
        String questionId = req.getParameter("questionId");
        req.setAttribute("questionId", questionId);
        list(req, resp);
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        QuestionItem byId = questionItemService.findById(id);
        req.setAttribute("questionItem", byId);
        list(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionItem questionItem = BeanUtil.fillBean(req, QuestionItem.class);
        questionItemService.update(questionItem);
        list(req, resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionItem questionItem = BeanUtil.fillBean(req, QuestionItem.class);
        questionItemService.save(questionItem);
        list(req, resp);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String questionId = req.getParameter("questionId");
        int page = 1;
        int pagesize = 100;
        PageInfo info = questionItemService.findAll(questionId, page, pagesize);
        req.setAttribute("page", info);
        req.setAttribute("questionId", questionId);
        req.getRequestDispatcher("/WEB-INF/pages/store/questionItem/list2.jsp").forward(req, resp);
    }
}
