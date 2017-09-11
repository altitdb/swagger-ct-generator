package com.matera.swagger.model.postman;

import java.util.List;

// Esse model deve receber um request gen�rico e refatorar para um request no padr�o Postman
public class Item {

	private String name;

	private Request request;

	private List<Response> response;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public List<Response> getResponse() {
		return response;
	}

	public void setResponse(List<Response> response) {
		this.response = response;
	}

}
