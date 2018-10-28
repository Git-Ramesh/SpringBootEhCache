package com.rs.app.actuator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import net.sf.ehcache.util.concurrent.ConcurrentHashMap;

@Endpoint(id = "customActuator")
@Component
public class CustomActuator {
	private Map<String, List<String>> map = new ConcurrentHashMap<>();

	public CustomActuator() {
		map.put("system", Arrays.asList("Lenovo G500"));
	}

	@ReadOperation
	public Map<String, List<String>> info() {
		return map;
	}

	@ReadOperation
	public List<String> particularInfo(@Selector String key) {
		return map.get(key);
	}

	@WriteOperation
	public void configure(@Selector String key, List<String> value) {
		map.put(key, value);
	}

	@DeleteOperation
	public void deleteConfiguration(@Selector String key) {
		map.remove(key);
	}

}
