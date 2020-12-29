package com.framework.core.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.session.web.http.CookieHttpSessionIdResolver;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
import org.springframework.session.web.http.HttpSessionIdResolver;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 扩展SessionID的存取策略
 * 根据请求头中是否包含(X-Requested-With)来选择不同的处理策略
 */
public class DynamicHttpSessionIdResolver implements HttpSessionIdResolver {

	/**
	 * 处理无状态的web请求 例如REST或App请求等
	 * 通过在Header当中加入x-auth-token来存取SessionId
	 * 客户端每次请求携带请求头 X-Auth-Token: 0dc1f6e1-c7f1-41ac-8ce2-32b6b3e57aa3
	 */
	private HeaderHttpSessionIdResolver headerHttpSessionIdResolver;

	/**
	 * 处理有状态的web请求 例如普通页面请求
	 * SessionId的存储由Cookie来完成.
	 */
	private CookieHttpSessionIdResolver cookieHttpSessionIdResolver;
	
	public DynamicHttpSessionIdResolver(HttpSessionIdResolver headerHttpSessionStrategy,
									  HttpSessionIdResolver cookieHttpSessionStrategy) {
		Assert.notNull(headerHttpSessionStrategy, "headerHttpSessionStrategy cannot be null");
		Assert.notNull(headerHttpSessionStrategy, "cookieHttpSessionStrategy cannot be null");
		this.headerHttpSessionIdResolver = headerHttpSessionIdResolver;
		this.cookieHttpSessionIdResolver = cookieHttpSessionIdResolver;
	}

	@Override
	public List<String> resolveSessionIds(HttpServletRequest request) {
		String requestType = request.getHeader("X-Requested-With");
		if("XMLHttpRequest".equals(requestType)) { //Ajax Request
			List<String> sessionIds = headerHttpSessionIdResolver.resolveSessionIds(request);
			if(!sessionIds.isEmpty()) {
				return sessionIds;
			}
		}
		return cookieHttpSessionIdResolver.resolveSessionIds(request);
	}

	@Override
	public void setSessionId(HttpServletRequest request, HttpServletResponse response, String sessionId) {
		headerHttpSessionIdResolver.setSessionId(request, response, sessionId);
		cookieHttpSessionIdResolver.setSessionId(request, response, sessionId);
	}

	@Override
	public void expireSession(HttpServletRequest request, HttpServletResponse response) {
		headerHttpSessionIdResolver.expireSession(request, response);
		cookieHttpSessionIdResolver.expireSession(request, response);
	}
}
