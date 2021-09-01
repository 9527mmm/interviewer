package com.zxk.web.controller.store;

import com.github.pagehelper.PageInfo;
import com.zxk.domain.store.Catalog;
import com.zxk.domain.store.Course;
import com.zxk.service.store.CatalogService;
import com.zxk.service.store.CourseService;
import com.zxk.service.store.impl.CatalogServiceImpl;
import com.zxk.service.store.impl.CourseServiceImpl;
import com.zxk.utils.BeanUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:47
 **/
@WebServlet("/store/catalog")
public class CatalogServlet extends HttpServlet {
    private CatalogService catalogService = new CatalogServiceImpl();
    private CourseService courseService=new CourseServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if ("list".equals(operation)) {
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
        }
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Course> all = courseService.findAll();
        req.setAttribute("courseList",all);
        req.getRequestDispatcher("/WEB-INF/pages/store/catalog/add.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Catalog catalog = BeanUtil.fillBean(req, Catalog.class);
        catalogService.delete(catalog);
        resp.sendRedirect(req.getContextPath() + "/store/catalog?operation=list");
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Catalog catalog = catalogService.findById(id);
        req.setAttribute("catalog", catalog);
        List<Course> all = courseService.findAll();
        req.setAttribute("courseList",all);
        req.getRequestDispatcher("/WEB-INF/pages/store/catalog/update.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Catalog catalog = BeanUtil.fillBean(req, Catalog.class, "yyyy-MM-dd");
        catalogService.update(catalog);
        resp.sendRedirect(req.getContextPath() + "/store/catalog?operation=list");
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Catalog catalog = BeanUtil.fillBean(req, Catalog.class, "yyyy-MM-dd");
        catalogService.save(catalog);
        resp.sendRedirect(req.getContextPath() + "/store/catalog?operation=list");

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
        PageInfo all = catalogService.findAll(page, size);
        req.setAttribute("page", all);
        req.getRequestDispatcher("/WEB-INF/pages/store/catalog/list.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
