package com.zxk.web.controller.system;

import com.github.pagehelper.PageInfo;
import com.zxk.domain.system.Dept;
import com.zxk.service.system.DeptService;
import com.zxk.service.system.impl.DeptServiceImpl;
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
@WebServlet("/system/dept")
public class DeptServlet extends HttpServlet {
    private DeptService deptService = new DeptServiceImpl();

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
        List<Dept> all = deptService.findAll();
        req.setAttribute("deptList", all);
        req.getRequestDispatcher("/WEB-INF/pages/system/dept/add.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dept dept = BeanUtil.fillBean(req, Dept.class);
        deptService.delete(dept);
        resp.sendRedirect(req.getContextPath() + "/system/dept?operation=list");
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> all = deptService.findAll();
        req.setAttribute("deptList", all);
        String id = req.getParameter("id");
        Dept dept = deptService.findById(id);
        req.setAttribute("dept", dept);
        req.getRequestDispatcher("/WEB-INF/pages/system/dept/update.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dept dept = BeanUtil.fillBean(req, Dept.class, "yyyy-MM-dd");
        deptService.update(dept);
        resp.sendRedirect(req.getContextPath() + "/system/dept?operation=list");
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dept dept = BeanUtil.fillBean(req, Dept.class, "yyyy-MM-dd");
        deptService.save(dept);
        resp.sendRedirect(req.getContextPath() + "/system/dept?operation=list");

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
        PageInfo all = deptService.findAll(page, size);
        req.setAttribute("page", all);
        req.getRequestDispatcher("/WEB-INF/pages/system/dept/list.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
