package com.zxk.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-31 20:05
 **/
//@WebFilter("/*")
public class F005AuthorFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        String substring = requestURI.substring(1);
        if (substring.endsWith(".js") ||
                substring.endsWith("index.jsp") ||
                substring.endsWith("login.jsp") ||
                substring.endsWith(".png") ||
                substring.endsWith(".css") ||
                substring.endsWith(".ico") ||
                substring.endsWith("unauthorized.jsp") ||
                substring.endsWith(".jpg")
        ) {
            chain.doFilter(req, resp);
            return;
        }

        String queryString = req.getQueryString();
        int i = queryString.indexOf("&");
        queryString = i != -1 ? queryString.substring(0, i) : queryString;
        if (queryString.endsWith("operation=home") || queryString.endsWith("operation=login")) {
            chain.doFilter(req, resp);
            return;
        }
        String author =req.getSession().getAttribute("author").toString();
        String road = substring + "?" + queryString;
        System.out.println("road"+road);
        System.out.println(author);
        if (author.contains(road)) {
            chain.doFilter(req, resp);
            return;
        }else {
            resp.sendRedirect(req.getContextPath()+"/unauthorized.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
