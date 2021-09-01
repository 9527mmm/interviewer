package com.zxk.web.controller.system;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.zxk.domain.system.Role;
import com.zxk.service.system.ModuleService;
import com.zxk.service.system.RoleService;
import com.zxk.service.system.impl.ModuleServiceImpl;
import com.zxk.service.system.impl.RoleServiceImpl;
import com.zxk.utils.BeanUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:47
 **/
@WebServlet("/system/role")
public class RoleServlet extends HttpServlet {
    private RoleService roleService = new RoleServiceImpl();
    private ModuleService moduleService=new ModuleServiceImpl();
    private ObjectMapper mapper=new ObjectMapper();

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
        }else if("author".equals(operation)){
            author(req,resp);
        }else if("updateRoleModule".equals(operation)){
            updateRoleModule(req,resp);
        }
    }

    private void updateRoleModule(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String roleId = req.getParameter("roleId");
        String moduleIds = req.getParameter("moduleIds");
        String[] moduleIds1 = req.getParameterValues("moduleId");
        System.out.println(moduleIds);
        roleService.updateRoleModule(roleId,moduleIds);
        resp.sendRedirect(req.getContextPath() + "/system/role?operation=list");
    }

    private void author(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleId = req.getParameter("id");
        Role role = roleService.findById(roleId);
        req.setAttribute("role",role);
        List<Map> map = moduleService.findAuthorDataByRoleID(roleId);
        String fadbr = mapper.writeValueAsString(map);
        req.setAttribute("fadbr",fadbr);


        req.getRequestDispatcher("/WEB-INF/pages/system/role/author.jsp").forward(req,resp);

    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Role> all = roleService.findAll();
        req.setAttribute("RoleList", all);
        req.getRequestDispatcher("/WEB-INF/pages/system/role/add.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Role role = BeanUtil.fillBean(req, Role.class);
        roleService.delete(role);
        resp.sendRedirect(req.getContextPath() + "/system/role?operation=list");
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Role role = roleService.findById(id);
        req.setAttribute("role", role);
        req.getRequestDispatcher("/WEB-INF/pages/system/role/update.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Role role = BeanUtil.fillBean(req, Role.class, "yyyy-MM-dd");
        roleService.update(role);
        resp.sendRedirect(req.getContextPath() + "/system/role?operation=list");
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Role role = BeanUtil.fillBean(req, Role.class, "yyyy-MM-dd");
        roleService.save(role);
        resp.sendRedirect(req.getContextPath() + "/system/role?operation=list");

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
        PageInfo all = roleService.findAll(page, size);
        req.setAttribute("page", all);
        req.getRequestDispatcher("/WEB-INF/pages/system/role/list.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
