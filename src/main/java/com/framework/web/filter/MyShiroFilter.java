package com.framework.web.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.core.bean.JsonResult;
import com.framework.core.excepton.ErrorCode;
import com.framework.core.excepton.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class MyShiroFilter implements Filter {

    private ObjectMapper objectMapper;

    private Object lock = new Object();

    private ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("MyShiroFilter -> init");
        this.servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        ObjectMapper objectMapperToUse = this.objectMapper;
        if (objectMapperToUse == null) {

            synchronized (this.lock) {
                objectMapperToUse = this.objectMapper;
                if (objectMapperToUse == null) {

                    WebApplicationContext wac = WebApplicationContextUtils.findWebApplicationContext(servletContext);
                    if (wac == null) {
                        throw new IllegalStateException("No WebApplicationContext found: " +
                                "no ContextLoaderListener or DispatcherServlet registered?");
                    }
                    objectMapperToUse = wac.getBean(ObjectMapper.class);
                }
                this.objectMapper = objectMapperToUse;
            }
        }

        invokeFilter(request, response, chain);
    }

    private void invokeFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            if (e.getCause() instanceof PermissionException) {
                PermissionException pe = (PermissionException) e.getCause();

                JsonResult result = new JsonResult();
                result.setSuccess(false);
                result.setCode(pe.getCode());
                result.setMessage(ErrorCode.getErrorMsg(pe.getCode()));

                response.setContentType("application/json;charset=UTF-8");
                objectMapper.writeValue(response.getOutputStream(), result);
                return;
            }
            throw e;
        }
    }

    @Override
    public void destroy() {
        log.debug("MyShiroFilter -> destroy");
    }
}
