package com.framework.core.shiro;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

/**
 * Shiro.Session缓存管理器
 */
public class SessionCacheManager extends AbstractCacheManager {

	@Override
	protected Cache<Object, Object> createCache(String name) throws CacheException {
		return new SessionCache(name);
	}

}
