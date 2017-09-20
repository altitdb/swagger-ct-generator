package com.matera.swagger.model.swagger;

import java.util.List;

public class Path {

	private List<Parameter> parameters;
	private HttpMethod get;
	private HttpMethod post;
	private HttpMethod delete;
	private HttpMethod put;

	public List<Parameter> getParameters() {
		return parameters;
	}

	public HttpMethod getGet() {
		return get;
	}

	public HttpMethod getPost() {
		return post;
	}

	public HttpMethod getDelete() {
		return delete;
	}

	public HttpMethod getPut() {
		return put;
	}

}
