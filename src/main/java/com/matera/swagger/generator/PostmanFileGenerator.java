package com.matera.swagger.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.matera.swagger.model.postman.Postman;
import com.matera.swagger.model.postman.Variable;
import com.matera.swagger.model.swagger.Path;
import com.matera.swagger.model.swagger.Swagger;
import com.matera.swagger.template.postman.TemplateInfo;
import com.matera.swagger.template.postman.TemplateItem;

public class PostmanFileGenerator {

	private static final String HTTP = "http://";

	public static void postmanFileGenerator(Postman postman, Swagger swagger) {

		List<Variable> variables = new ArrayList<>();
		postman.setVariables(variables);

		TemplateInfo.generateTemplateInfo(postman, swagger);

		for (Map.Entry<String, Path> path : swagger.getPaths().entrySet()) {

			String url = HTTP + swagger.getHost() + swagger.getBasePath() + path.getKey();

			TemplateItem.generateTempalteItem(url, postman, path.getValue());
		}

		FileGenerator.generateFile("", postman);

	}

}
