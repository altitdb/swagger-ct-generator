package com.matera.swagger.template.postman;

import com.matera.swagger.model.postman.InfoPostman;
import com.matera.swagger.model.postman.Postman;
import com.matera.swagger.model.swagger.Swagger;

public class TemplateInfo {

	private static final String SCHEMA = "https://schema.getpostman.com/json/collection/v2.0.0/collection.json";

	public static void generateTemplateInfo(Postman postman, Swagger swagger) {

		InfoPostman info = new InfoPostman();
		info.setName(swagger.getInfo().getTitle());
		info.setDescription(swagger.getInfo().getDescription());
		info.setSchema(SCHEMA);

		postman.setInfo(info);

	}

}
