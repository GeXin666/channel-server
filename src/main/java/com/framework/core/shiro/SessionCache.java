package com.framework.core.shiro;

import java.util.Collection;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Shiro.Session缓存实现
 * 将数据缓存到当前用户的Session中,这样缓存的生命周期与Session一致.
 */
public class SessionCache implements Cache<Object, Object> {

	private static final Logger log = LoggerFactory.getLogger(SessionCache.class);

	private final String cacheName;
	
	public SessionCache(String cacheName) {
		this.cacheName = cacheName;
	}

	@Override
	public Object get(Object key) throws CacheException {
		Session session = getSession();
		String strKey = getCacheKey(key);

		Object value = session.getAttribute(strKey);
		if (log.isDebugEnabled()) {
			log.debug("Using Cache[" + cacheName + "] Getting cached object [" + value + "] " +
					"form session [" + session.getId() + "] for key [" + strKey + "].");
		} 
		
		return value;
	}

	@Override
	public Object put(Object key, Object value) throws CacheException {
		Session session = getSession();
		String strKey = getCacheKey(key);

		Object oldValue = session.getAttribute(strKey);
		session.setAttribute(strKey, value);
		if (log.isDebugEnabled()) {
            log.debug("Using Cache[" + cacheName + "] : Putting object [" + value + "] " +
            		"in session [" + session.getId() + "] for key [" + strKey+ "].");
        }
		
		return oldValue;
	}

	@Override
	public Object remove(Object key) throws CacheException {
		Session session = getSession();
		String strKey = getCacheKey(key);
		
		if(session != null) {
			Object oldValue = session.getAttribute(strKey);
			session.removeAttribute(strKey);
			if (log.isDebugEnabled()) {
	            log.debug("Using Cache[" + cacheName + "] : Removing object [" + oldValue + "] " +
	            		"in session [" + session.getId() + "] for key [" + strKey + "].");
	        }
			return oldValue;
		}
		
		return null;
	}

	private String getCacheKey(Object key) {
		if(!(key instanceof SimplePrincipalCollection)) {
			throw new ShiroException("SessionCache [" + cacheName + "] Key type must be SimplePrincipalCollection");
		}
		return cacheName + "-" + key.toString();
	}

	@Override
	public void clear() throws CacheException {
	}

	@Override
	public int size() {
		throw new UnsupportedOperationException("Unsupported method");
	}

	@Override
	public Set<Object> keys() {
		throw new UnsupportedOperationException("Unsupported method");
	}

	@Override
	public Collection<Object> values() {
		throw new UnsupportedOperationException("Unsupported method");
	}

	private Session getSession() {
		return SecurityUtils.getSubject().getSession(false);
	}
}
