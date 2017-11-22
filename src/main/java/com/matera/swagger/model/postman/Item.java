package com.matera.swagger.model.postman;

import java.util.List;

public class Item {

	private String name;
	private RequestPostman request;
	private List<Response> response;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RequestPostman getRequest() {
		return request;
	}

	public void setRequest(RequestPostman request) {
		this.request = request;
	}

	public List<Response> getResponse() {
		return response;
	}

	public void setResponse(List<Response> response) {
		this.response = response;
	}

}
