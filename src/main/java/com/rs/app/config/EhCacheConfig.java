package com.rs.app.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author ramesh
 * @version 1.0
 * @since 2018-10-20
 */
@Configuration
public class EhCacheConfig {
	
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
	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManagerFactoryBean().getObject());
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
		EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
		factoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		factoryBean.setShared(true);
		return factoryBean;
	}
}
