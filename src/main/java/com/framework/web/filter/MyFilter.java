package com.framework.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(filterName = "MyFilter", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println("MyFilter is begin" + request.getRequestURI());
        chain.doFilter(request, response);
        System.out.println("MyFilter is end");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter is going destroy");
    }
}
