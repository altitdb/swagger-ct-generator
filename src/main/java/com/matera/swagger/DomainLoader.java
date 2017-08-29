package com.matera.swagger;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DomainLoader {

	private static final Logger LOG = LogManager.getRootLogger();
	private static final Set<String> URI_DOMAIN = new TreeSet<String>();
	private static final Set<String> HEADER_DOMAIN = new TreeSet<String>();
	private static final Set<String> PATH_DOMAIN = new TreeSet<String>();
	private static final Set<String> QUERY_DOMAIN = new TreeSet<String>();
	private static final Set<String> BODY_DOMAIN = new TreeSet<String>();

	public Set<String> getUriDomain() {
		return URI_DOMAIN;
	}

	public Set<String> getHeaderDomain() {
		return HEADER_DOMAIN;
	}

	public Set<String> getPathDomain() {
		return PATH_DOMAIN;
	}

	public Set<String> getQueryDomain() {
		return QUERY_DOMAIN;
	}

	public Set<String> getBodyDomain() {
		return BODY_DOMAIN;
	}

	public void loader(String json) {
		if (StringUtils.isBlank(json)) {
			throw new IllegalArgumentException("Json cannot be null or empty.");
		}
		JSONParser parser = new JSONParser();
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(json);
			JSONObject paths = (JSONObject) jsonObject.get("paths");
			for (Object key : paths.keySet()) {
				handleUriDomain(jsonObject, key);
				JSONObject object = (JSONObject) paths.get(key);
				handleDomains(jsonObject, object);
			}
		} catch (ParseException pe) {
			LOG.error("Exists problems in parser.", pe);
		}
	}

	private void handleUriDomain(JSONObject jsonObject, Object key) {
		String basePath = (String) jsonObject.get("basePath");
		String uriDomain = basePath + key;
		LOG.debug("Adding new URI domain: {}", uriDomain);
		URI_DOMAIN.add(uriDomain);
	}

	private void handleDomains(JSONObject jsonObject, JSONObject object) {
		LOG.debug("Parsing Path Object {}", object);
		handleParameters(object);
		handleMethodGet(object);
		handleMethodPost(jsonObject, object);
		handleMethodDelete(jsonObject, object);
	}

	private void handleMethodDelete(JSONObject jsonObject, JSONObject object) {
		JSONObject delete = (JSONObject) object.get("delete");
		if (delete != null) {
			JSONArray arrayParameters = (JSONArray) delete.get("parameters");
			if (arrayParameters != null) {
				handleHeaderDomain(arrayParameters);
				handleQueryDomain(arrayParameters);
				handleBodyDomain(jsonObject, arrayParameters);
			}
		}
	}

	private void handleBodyDomain(JSONObject jsonObject, JSONArray arrayParameters) {
		Set<String> domain = handleDomain(jsonObject, arrayParameters);
		BODY_DOMAIN.addAll(domain);
	}

	private void handleHeaderDomain(JSONArray arrayParameters) {
		Set<String> domain = handleDomain(arrayParameters, "header");
		HEADER_DOMAIN.addAll(domain);
	}

	private void handleQueryDomain(JSONArray arrayParameters) {
		Set<String> domain = handleDomain(arrayParameters, "query");
		QUERY_DOMAIN.addAll(domain);
	}

	private void handleMethodPost(JSONObject jsonObject, JSONObject object) {
		JSONObject post = (JSONObject) object.get("post");
		if (post != null) {
			JSONArray arrayParameters = (JSONArray) post.get("parameters");
			if (arrayParameters != null) {
				handleHeaderDomain(arrayParameters);
				handleQueryDomain(arrayParameters);
				handleBodyDomain(jsonObject, arrayParameters);
			}
		}
	}

	private void handleMethodGet(JSONObject object) {
		JSONObject get = (JSONObject) object.get("get");
		if (get != null) {
			JSONArray arrayParameters = (JSONArray) get.get("parameters");
			if (arrayParameters != null) {
				handleHeaderDomain(arrayParameters);
				handleQueryDomain(arrayParameters);
			}
		}
	}

	private void handleParameters(JSONObject object) {
		JSONArray array = (JSONArray) object.get("parameters");
		if (array != null) {
			PATH_DOMAIN.addAll(handleDomain(array, "path"));
		}
	}

	@SuppressWarnings("unchecked")
	private static Set<String> handleDomain(JSONArray array, String type) {
		Set<String> pathsDomain = new HashSet<String>();
		array.stream().filter(json -> ((JSONObject) json).get("in").equals(type))
				.forEach(i -> pathsDomain.add(((JSONObject) i).get("name").toString()));
		return pathsDomain;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	private static Set<String> handleDomain(JSONObject jsonObject, JSONArray array) {
		Set<String> pathsDomain = new HashSet<String>();
		Optional findFirst = array.stream().filter(json -> ((JSONObject) json).get("in").equals("body")).findFirst();
		if (findFirst.isPresent()) {
			JSONObject object = (JSONObject) findFirst.get();
			JSONObject schema = (JSONObject) object.get("schema");
			String definitionName = schema.toString().split("/")[2].replaceAll("\"\\}", "");
			JSONObject definitions = (JSONObject) jsonObject.get("definitions");
			JSONObject definition = (JSONObject) definitions.get(definitionName);
			JSONObject properties = (JSONObject) definition.get("properties");
			for (Object key : properties.keySet()) {
				JSONObject keyObject = (JSONObject) properties.get(key);
				if (keyObject.get("$ref") != null) {
					String newKey = keyObject.get("$ref").toString().split("/")[2];
					JSONObject definition2 = (JSONObject) definitions.get(newKey);
					JSONObject properties2 = (JSONObject) definition2.get("properties");
					for (Object key2 : properties2.keySet()) {
						pathsDomain.add(key2.toString());
					}
				} else {
					pathsDomain.add(key.toString());
				}
			}
		}
		return pathsDomain;
	}
}
