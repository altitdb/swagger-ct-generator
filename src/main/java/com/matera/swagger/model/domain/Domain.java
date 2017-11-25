package com.matera.swagger.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Domain {

	private static final int ZERO_VALUES_FROM_DOMAIN = 0;
	private static final int RESPONSE_SUCCESS = 200;
	private static final Logger LOG = LogManager.getRootLogger();
	private Map<String, Map<Integer, Object>> domains = new HashMap<>();

	public void add(String key, String value, Integer responseCode) {
		LOG.info(String.format("Adding %s with value %s to response code %s", key, value, responseCode));
		Map<Integer, Object> values = domains.get(key);
		if (values == null) {
			values = new HashMap<>();
		}
		values.put(responseCode, value);
		domains.put(key, values);
	}

	public Integer getDomainsFromKey(String key) {
		Map<Integer, Object> values = domains.get(key);
		if (values == null) {
			return ZERO_VALUES_FROM_DOMAIN;
		}
		return values.size();
	}

	public Object getSuccess(String key) {
		Map<Integer, Object> values = domains.get(key);
		if (values == null) {
			return null;
		}
		return values.get(RESPONSE_SUCCESS);
	}

	public List<Object> getError(String key) {
		Map<Integer, Object> values = domains.get(key);
		if (values == null) {
			return Collections.emptyList();
		}
		Map<Integer, Object> newValues = new HashMap<>(values);
		newValues.remove(RESPONSE_SUCCESS);
		return new ArrayList<>(newValues.values());
	}

}
