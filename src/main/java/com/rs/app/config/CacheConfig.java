package com.rs.app.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ramesh
 * @version 1.0
 * @since 2018-10-20
 */
@Configuration
public class CacheConfig {
	
	/**
	 * <p>
	 * Note: This is by no means a sophisticated CacheManager; it comes with no
	 * cache configuration options. However, it may be useful for testing or simple
	 * caching scenarios. For advanced local caching needs, consider
	 * {@link org.springframework.cache.jcache.JCacheCacheManager},
	 * {@link org.springframework.cache.ehcache.EhCacheCacheManager},
	 * {@link org.springframework.cache.caffeine.CaffeineCacheManager}.
	 */
	//In Spring Boot application you need not to explicitly configure CacheManager
	//You have to add a property in application.proerties like spring.cache.cache-names=foo, bar
//	@Bean
//	public CacheManager cacheManager() {
//		return new ConcurrentMapCacheManager("usersCache");
//	}
}
