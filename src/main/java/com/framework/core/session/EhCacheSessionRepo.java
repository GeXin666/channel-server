package com.framework.core.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.session.MapSession;
import org.springframework.session.SessionRepository;

import javax.cache.Cache;
import java.time.Duration;
import java.time.Instant;

@Slf4j
public class EhCacheSessionRepo implements SessionRepository<MapSession> {

    /**
     * 缓存名称
     */
    private String cacheName;

    /**
     * Session空闲时间(秒)
     */
    private long maxSessionInactiveInterval;

    /**
     * Session缓存
     */
    private Cache<String, MapSession> sessionCache;

    public EhCacheSessionRepo(Cache<String, MapSession> sessionCache, long maxSessionInactiveInterval) {
        this.cacheName = sessionCache.getName();
        this.sessionCache = sessionCache;
        this.maxSessionInactiveInterval = maxSessionInactiveInterval;
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
        MapSession session = sessionCache.get(id);
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
        sessionCache.remove(id);
    }
}
