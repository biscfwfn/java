package com.test.sun.interceptor;

import com.test.sun.Utils.CusAccessObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器 能拿到http请求，但是拿不到处理请求方法的信息。
 */
@WebFilter(filterName = "test", urlPatterns = "/*")
public class UserDefinedFilter implements Filter {

    private static Logger log = LoggerFactory.getLogger(UserDefinedFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter 处理请求");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String url = req.getRequestURI();
        long start = System.currentTimeMillis();
        if(!url.startsWith("/file")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            res.setContentType("text/html;charset=UTF-8");
            res.getWriter().write("禁止访问");
        }
        log.info(CusAccessObjectUtil.getIpAddress(req) + " " + url + " " + res.getStatus() + " " + (System.currentTimeMillis()-start) + "ms");
    }

    @Override
    public void destroy() {
        System.out.println("filter 销毁");
    }
}
