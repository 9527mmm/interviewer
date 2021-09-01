package com.zxk.web.controller.store;

import com.github.pagehelper.PageInfo;
import com.zxk.domain.store.Company;
import com.zxk.service.store.CompanyService;
import com.zxk.service.store.impl.CompanyServiceImpl;
import com.zxk.utils.BeanUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:47
 **/
@WebServlet("/store/company")
public class CompanyServlet extends HttpServlet {
    private CompanyService companyService = new CompanyServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
       /* if ("list".equals(operation)) {
            list(req, resp);
        } else if ("toAdd".equals(operation)) {
            toAdd(req, resp);
        } else if ("save".equals(operation)) {
            save(req, resp);
        } else if ("delete".equals(operation)) {
            delete(req, resp);
        } else if ("toEdit".equals(operation)) {
            toEdit(req, resp);
        } else if ("edit".equals(operation)) {
            edit(req, resp);
        }*/

        try {
            Method method = this.getClass().getDeclaredMethod(operation, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/store/company/add.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Company company = BeanUtil.fillBean(req, Company.class);
        companyService.delete(company);
        resp.sendRedirect(req.getContextPath() + "/store/company?operation=list");
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Company company = companyService.findById(id);
        req.setAttribute("company", company);
        req.getRequestDispatcher("/WEB-INF/pages/store/company/update.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Company company = BeanUtil.fillBean(req, Company.class, "yyyy-MM-dd");
        companyService.update(company);
        resp.sendRedirect(req.getContextPath() + "/store/company?operation=list");
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Company company = BeanUtil.fillBean(req, Company.class, "yyyy-MM-dd");
        companyService.save(company);
        resp.sendRedirect(req.getContextPath() + "/store/company?operation=list");

    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int size = 5;
        if (StringUtils.isNotBlank(req.getParameter("page"))) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        if (StringUtils.isNotBlank(req.getParameter("size"))) {
            size = Integer.parseInt(req.getParameter("size"));
        }
        PageInfo all = companyService.findAll(page, size);
        req.setAttribute("page", all);
        req.getRequestDispatcher("/WEB-INF/pages/store/company/list.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
