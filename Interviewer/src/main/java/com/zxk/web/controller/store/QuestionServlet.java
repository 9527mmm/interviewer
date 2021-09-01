package com.zxk.web.controller.store;

import com.github.pagehelper.PageInfo;
import com.zxk.domain.store.Catalog;
import com.zxk.domain.store.Company;
import com.zxk.domain.store.Question;
import com.zxk.service.store.CatalogService;
import com.zxk.service.store.CompanyService;
import com.zxk.service.store.QuestionService;
import com.zxk.service.store.impl.CatalogServiceImpl;
import com.zxk.service.store.impl.CompanyServiceImpl;
import com.zxk.service.store.impl.QuestionServiceImpl;
import com.zxk.utils.BeanUtil;
import com.zxk.utils.UUIDUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

import javax.activation.MimeType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 10:47
 **/
@WebServlet("/store/question")
public class QuestionServlet extends HttpServlet {
    private QuestionService questionService = new QuestionServiceImpl();
    private CompanyService companyService = new CompanyServiceImpl();
    private CatalogService catalogService = new CatalogServiceImpl();

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
        } else if ("toExport".equals(operation)) {
            toExport(req, resp);
        } else if ("upload".equals(operation)) {
            upload(req, resp);


        }
    }

    private void upload(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (ServletFileUpload.isMultipartContent(req)) {
                DiskFileItemFactory fif = new DiskFileItemFactory();
                ServletFileUpload sfu = new ServletFileUpload(fif);
                List<FileItem> fileItems = sfu.parseRequest(req);
                String excelPath = null;
                for (FileItem fileItem : fileItems) {
                    String fileName = fileItem.getName();
                    if (!fileItem.isFormField()) {
                        if (StringUtils.isNotBlank(fileName)) {
                            //解决文件名重复，uuid
                            fileName = UUIDUtil.getUUID32()+".xlsx";
                            //解决问题二，目录分离
                            char d1 = fileName.charAt(0);
                            char d2 = fileName.charAt(1);
                            char d3 = fileName.charAt(2);
                            String parentDirStr = getServletContext().getRealPath("abc") + "/" + d1 + "/" + d2 + "/" + d3;
                            File parentFile = new File(parentDirStr);
                            if (!parentFile.exists()) {
                                parentFile.mkdirs();
                            }
                            excelPath=parentDirStr+"/"+fileName;
                            fileItem.write(new File(parentDirStr, fileName));
                        }
                    }
                }
                questionService.upload(excelPath);
            }

            resp.sendRedirect(req.getContextPath() + "/store/question?operation=list");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void toExport(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fileName = UUIDUtil.getUUID32() + ".xlsx";
        ServletContext sc = req.getServletContext();
        String templatePath = sc.getRealPath("template/test_template.xlsx");
        System.out.println(templatePath);
        String mimeType = sc.getMimeType(fileName);
        resp.setHeader("content-type", mimeType);
        resp.setHeader("content-disposition", "attachment:filename=" + fileName);
        ServletOutputStream outputStream = resp.getOutputStream();
        questionService.toExport(templatePath, outputStream);

    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> all = companyService.findAll();
        req.setAttribute("companyList", all);
        List<Catalog> all1 = catalogService.findAll();
        req.setAttribute("catalogList", all1);
        req.getRequestDispatcher("/WEB-INF/pages/store/question/add.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Question question = BeanUtil.fillBean(req, Question.class);
        questionService.delete(question);
        resp.sendRedirect(req.getContextPath() + "/store/question?operation=list");
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> all = companyService.findAll();
        req.setAttribute("companyList", all);
        List<Catalog> all1 = catalogService.findAll();
        req.setAttribute("catalogList", all1);
        String id = req.getParameter("id");
        Question question = questionService.findById(id);
        req.setAttribute("question", question);
        req.getRequestDispatcher("/WEB-INF/pages/store/question/update.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (ServletFileUpload.isMultipartContent(req)) {
                DiskFileItemFactory fif = new DiskFileItemFactory();
                ServletFileUpload sfu = new ServletFileUpload(fif);
                List<FileItem> fileItems = sfu.parseRequest(req);
                Question question = BeanUtil.fillBean(fileItems, Question.class);
                //之前的picture
                String picture = question.getPicture();
                for (FileItem fileItem : fileItems) {
                    String fileName = fileItem.getName();
                    if (!fileItem.isFormField()) {
                        //判断现在有没有图片
                        if (StringUtils.isNotBlank(fileName)) {
                            //判断之前有没有图片
                            if (StringUtils.isBlank(picture)) {
                                //解决文件名重复，uuid
                                fileName = UUIDUtil.getUUID32();
                                //解决问题二，目录分离
                                char d1 = fileName.charAt(0);
                                char d2 = fileName.charAt(1);
                                char d3 = fileName.charAt(2);
                                String parentDirStr = getServletContext().getRealPath("upload") + "/" + d1 + "/" + d2 + "/" + d3;
                                File parentFile = new File(parentDirStr);
                                if (!parentFile.exists()) {
                                    parentFile.mkdirs();
                                }
                                picture = d1 + "/" + d2 + "/" + d3 + "/" + fileName;
                                fileItem.write(new File(parentDirStr, fileName));
                            } else {
                                fileItem.write(new File(getServletContext().getRealPath("upload/"), picture));
                            }
                        }

                    }
                }
                question.setPicture(picture);
                questionService.update(question);
            }
            resp.sendRedirect(req.getContextPath() + "/store/question?operation=list");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {

        try {
            if (ServletFileUpload.isMultipartContent(req)) {
                DiskFileItemFactory fif = new DiskFileItemFactory();
                ServletFileUpload sfu = new ServletFileUpload(fif);
                List<FileItem> fileItems = sfu.parseRequest(req);
                String picture = null;
                for (FileItem fileItem : fileItems) {
                    String fileName = fileItem.getName();
                    if (!fileItem.isFormField()) {
                        if (StringUtils.isNotBlank(fileName)) {
                            //解决文件名重复，uuid
                            fileName = UUIDUtil.getUUID32();
                            //解决问题二，目录分离
                            char d1 = fileName.charAt(0);
                            char d2 = fileName.charAt(1);
                            char d3 = fileName.charAt(2);
                            String parentDirStr = getServletContext().getRealPath("upload") + "/" + d1 + "/" + d2 + "/" + d3;
                            File parentFile = new File(parentDirStr);
                            if (!parentFile.exists()) {
                                parentFile.mkdirs();
                            }
                            picture = d1 + "/" + d2 + "/" + d3 + "/" + fileName;
                            fileItem.write(new File(parentDirStr, fileName));
                        }
                    }
                }
                Question question = BeanUtil.fillBean(fileItems, Question.class);
                question.setPicture(picture);
                questionService.save(question);
            }

            resp.sendRedirect(req.getContextPath() + "/store/question?operation=list");
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        PageInfo all = questionService.findAll(page, size);
        req.setAttribute("page", all);
        req.getRequestDispatcher("/WEB-INF/pages/store/question/list.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
