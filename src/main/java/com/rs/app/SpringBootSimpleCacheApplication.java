package com.rs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
/*
 * actuator/metrics/cache.puts
 * actuator/metrics/cache.gets
 * actuator/metrics/cache.size
 */
/**
 * 
 * @author ramesh
 */
@SpringBootApplication
@EnableCaching
public class SpringBootSimpleCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSimpleCacheApplication.class, args);
	}
}
