package com.matera.swagger.model.postman;

import java.util.List;

public class RequestPostman {

	private String url;

	private String method;

	private List<HeaderPostman> header;

	private BodyPostman body;

	private String description;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public List<HeaderPostman> getHeader() {
		return header;
	}

	public void setHeader(List<HeaderPostman> header) {
		this.header = header;
	}

	public BodyPostman getBody() {
		return body;
	}

	public void setBody(BodyPostman body) {
		this.body = body;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
