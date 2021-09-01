package com.zxk.web.controller.system;

import com.github.pagehelper.PageInfo;
import com.zxk.domain.system.Module;
import com.zxk.service.system.ModuleService;
import com.zxk.service.system.impl.ModuleServiceImpl;
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
@WebServlet("/system/module")
public class ModuleServlet extends HttpServlet {
    private ModuleService moduleService = new ModuleServiceImpl();

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
        List<Module> all = moduleService.findAll();
        req.setAttribute("moduleList", all);
        req.getRequestDispatcher("/WEB-INF/pages/system/module/add.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Module module = BeanUtil.fillBean(req, Module.class);
        moduleService.delete(module);
        resp.sendRedirect(req.getContextPath() + "/system/module?operation=list");
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Module> all = moduleService.findAll();
        req.setAttribute("moduleList", all);
        String id = req.getParameter("id");
        Module module = moduleService.findById(id);
        req.setAttribute("module", module);
        req.getRequestDispatcher("/WEB-INF/pages/system/module/update.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Module module = BeanUtil.fillBean(req, Module.class, "yyyy-MM-dd");
        moduleService.update(module);
        resp.sendRedirect(req.getContextPath() + "/system/module?operation=list");
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Module module = BeanUtil.fillBean(req, Module.class, "yyyy-MM-dd");
        moduleService.save(module);
        resp.sendRedirect(req.getContextPath() + "/system/module?operation=list");

    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int size = 10;
        if (StringUtils.isNotBlank(req.getParameter("page"))) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        if (StringUtils.isNotBlank(req.getParameter("size"))) {
            size = Integer.parseInt(req.getParameter("size"));
        }
        PageInfo all = moduleService.findAll(page, size);
        req.setAttribute("page", all);
        req.getRequestDispatcher("/WEB-INF/pages/system/module/list.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
