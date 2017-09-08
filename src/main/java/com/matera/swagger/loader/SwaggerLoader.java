package com.matera.swagger.loader;

import com.google.gson.Gson;
import com.matera.swagger.model.swagger.Swagger;

public class SwaggerLoader {

	public Swagger loader(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, Swagger.class);
	}
}
