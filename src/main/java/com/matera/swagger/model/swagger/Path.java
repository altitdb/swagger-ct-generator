package com.matera.swagger.model.swagger;

import java.util.List;
import java.util.Map;

public class Path {
	
	private List<Parameter> parameters;

	private Map<String, HttpMethod> httpMethod;

	public List<Parameter> getParameters() {
		return parameters;
	}

	public Map<String, HttpMethod> getHttpMethod() {
		return httpMethod;
	}

}
