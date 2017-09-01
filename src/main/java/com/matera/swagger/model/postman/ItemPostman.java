package com.matera.swagger.model.postman;

import java.util.List;

// Esse model deve receber um request genérico e refatorar para um request no padrão Postman
public class ItemPostman {

	private String name;

	private RequestPostman request;

	private List<ResponsePostman> response;

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

	public List<ResponsePostman> getResponse() {
		return response;
	}

	public void setResponse(List<ResponsePostman> response) {
		this.response = response;
	}
	
	@Override
	public String toString() {
		// Imprimir os atributos desse objeto no formato do JSON do postman
		return super.toString();
	}

}
