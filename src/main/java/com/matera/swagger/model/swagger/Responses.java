package com.matera.swagger.model.swagger;

import java.util.Map;

// Verificar pois no responses de um arquivo swagger pode ter ilimitados obetos response porem nao � uma lista
// Verificar se sempre s�o os mesmos status
public class Responses {

	private Map<String, Response> response;

	public Map<String, Response> getResponse() {
		return response;
	}

	public void setResponse(Map<String, Response> response) {
		this.response = response;
	}

}
