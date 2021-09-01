package com.zxk.web.controller.system;

import com.github.pagehelper.PageInfo;
import com.zxk.domain.system.Dept;
import com.zxk.domain.system.Module;
import com.zxk.domain.system.Role;
import com.zxk.domain.system.User;
import com.zxk.service.system.DeptService;
import com.zxk.service.system.ModuleService;
import com.zxk.service.system.RoleService;
import com.zxk.service.system.UserService;
import com.zxk.service.system.impl.DeptServiceImpl;
import com.zxk.service.system.impl.ModuleServiceImpl;
import com.zxk.service.system.impl.RoleServiceImpl;
import com.zxk.service.system.impl.UserServiceImpl;
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
@WebServlet("/system/user")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private DeptService deptService = new DeptServiceImpl();
    private RoleService roleService = new RoleServiceImpl();
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
        } else if ("userRoleList".equals(operation)) {
            userRoleList(req, resp);
        } else if ("updateRole".equals(operation)) {
            updateRole(req, resp);
        } else if ("login".equals(operation)) {
            login(req, resp);
        } else if ("logout".equals(operation)) {
            logout(req, resp);
        } else if ("home".equals(operation)) {
            req.getRequestDispatcher("/WEB-INF/pages/home/home.jsp").forward(req, resp);
        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().removeAttribute("user");
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = userService.login(email, password);
        System.out.println(user);
        if (user != null) {
            List<Module> modules = moduleService.findModuleByUid(user.getId());
            req.setAttribute("modules", modules);
            StringBuilder s = new StringBuilder();
            for (Module module : modules) {
                s.append(module.getCurl() + ",");
            }
            req.getSession().setAttribute("author", s.toString());
            req.getRequestDispatcher("/WEB-INF/pages/home/main.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }

    private void updateRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("userId");
        String[] roleIds = req.getParameterValues("roleIds");
        roleService.updateUserRoleByUID(uid, roleIds);
        resp.sendRedirect(req.getContextPath() + "/system/user?operation=list");
    }

    private void userRoleList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("id");
        User user = userService.findById(uid);
        req.setAttribute("user", user);
        List<Role> all = roleService.findUserRoleByUID(uid);
        req.setAttribute("roleList", all);
        req.getRequestDispatcher("/WEB-INF/pages/system/user/role.jsp").forward(req, resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> all = deptService.findAll();
        req.setAttribute("deptList", all);
        req.getRequestDispatcher("/WEB-INF/pages/system/user/add.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = BeanUtil.fillBean(req, User.class);
        userService.delete(user);
        resp.sendRedirect(req.getContextPath() + "/system/user?operation=list");
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> all = deptService.findAll();
        req.setAttribute("deptList", all);
        String id = req.getParameter("id");
        User user = userService.findById(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/pages/system/user/update.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = BeanUtil.fillBean(req, User.class, "yyyy-MM-dd");
        userService.update(user);
        resp.sendRedirect(req.getContextPath() + "/system/user?operation=list");
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = BeanUtil.fillBean(req, User.class, "yyyy-MM-dd");
        userService.save(user);
        resp.sendRedirect(req.getContextPath() + "/system/user?operation=list");

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
        PageInfo all = userService.findAll(page, size);
        req.setAttribute("page", all);
        req.getRequestDispatcher("/WEB-INF/pages/system/user/list.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
