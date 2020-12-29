package com.framework.core.convert;

import javax.servlet.http.HttpServletRequest;

import com.framework.core.mybatis.PageBounds;
import org.springframework.core.MethodParameter;
import org.springframework.util.Assert;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class PaginationParamConvert implements HandlerMethodArgumentResolver {
	
	private String pageParameterName = "page";
	
	private String limitParameterName = "limit";

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return PageBounds.class == parameter.getParameterType();
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest request = (HttpServletRequest)webRequest.getNativeRequest();
		
		int page = ServletRequestUtils.getRequiredIntParameter(request, pageParameterName);
		int limit = ServletRequestUtils.getRequiredIntParameter(request, limitParameterName);
		PageBounds paginationParam = new PageBounds(page, limit);
		
		return paginationParam;
	}

	public void setPageParameterName(String pageParameterName) {
		Assert.notNull(pageParameterName, "pageParameterName cannot be null");
		this.pageParameterName = pageParameterName;
	}

	public void setLimitParameterName(String limitParameterName) {
		Assert.notNull(limitParameterName, "limitParameterName cannot be null");
		this.limitParameterName = limitParameterName;
	}
}
