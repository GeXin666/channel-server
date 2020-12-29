package com.framework.core.session;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.session.MapSession;
import org.springframework.session.SessionRepository;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GuavaCacheSessionRepo implements SessionRepository<MapSession> {

    /**
     * 缓存名称
     */
    private String cacheName;

    /**
     * Session空闲时间(秒)
     */
    private long maxSessionInactiveInterval;

    /**
     * GuavaCache缓存Session
     */
    private Cache<String, MapSession> sessionCache;

    public GuavaCacheSessionRepo(String cacheName) {
        this(cacheName, MapSession.DEFAULT_MAX_INACTIVE_INTERVAL_SECONDS);
    }

    public GuavaCacheSessionRepo(String cacheName, long maxSessionInactiveInterval) {
        this.cacheName = cacheName;
        this.maxSessionInactiveInterval = maxSessionInactiveInterval;
        this.sessionCache = CacheBuilder.newBuilder().
                expireAfterAccess(maxSessionInactiveInterval, TimeUnit.SECONDS).build();
    }

    @Override
    public MapSession createSession() {
        MapSession session = new MapSession();
        session.setMaxInactiveInterval(Duration.ofSeconds(maxSessionInactiveInterval));

        if (log.isInfoEnabled()) {
            log.info("Create NewSession:[{}] SessionId:[{}]", session, session.getId());
        }
        return session;
    }

    @Override
    public void save(MapSession session) {
        if (log.isInfoEnabled()) {
            log.info("Saving Session in cache:[{}] SessionId:[{}]", cacheName, session.getId());
        }
        sessionCache.put(session.getId(), new MapSession(session));
    }

    @Override
    public MapSession findById(String id) {
        MapSession session = sessionCache.getIfPresent(id);
        if(session == null) {
            if (log.isWarnEnabled()) {
                log.warn("Session not find from cache:[{}]  SessionId:[{}]", cacheName, id);
            }
            return null;
        }

        if(session.isExpired()) {
            if (log.isWarnEnabled()) {
                log.warn("Session is expired from cache:[{}] SessionId:[{}]", cacheName, id);
            }
            deleteById(session.getId());
            return null;
        }

        if (log.isInfoEnabled()) {
            log.info("Getting Session from cache:[{}] SessionId:[{}]", cacheName, id);
        }

        MapSession result = new MapSession(session);
        result.setLastAccessedTime(Instant.now());

        return result;
    }

    @Override
    public void deleteById(String id) {
        if (log.isInfoEnabled()) {
            log.info("Deleteing Session from cache:[{}] SessionId:[{}]", cacheName, id);
        }
        sessionCache.invalidate(id);
    }
}
