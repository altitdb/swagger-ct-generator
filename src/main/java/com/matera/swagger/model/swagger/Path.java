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

	public void setGet(HttpMethod get) {
		this.get = get;
	}

	public void setPost(HttpMethod post) {
		this.post = post;
	}

	public void setDelete(HttpMethod delete) {
		this.delete = delete;
	}

	public void setPut(HttpMethod put) {
		this.put = put;
	}

	public String getMethod() {
		if (get != null) {
			return "GET";
		} else if (post != null) {
			return "POST";
		} else if (put != null) {
			return "PUT";
		} else if (delete != null) {
			return "DELETE";
		}
		throw new IllegalArgumentException("Method does match with GET, POST, PUT or DELETE");
	}

}
