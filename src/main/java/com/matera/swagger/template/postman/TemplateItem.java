package com.matera.swagger.template.postman;

import com.matera.swagger.model.postman.Postman;
import com.matera.swagger.model.swagger.Path;

public class TemplateItem {

	public static void generateTempalteItem(String url, Postman postman, Path path) {

		if (path.getPost() != null) {
			TemplatePost.generateTemplatePost(url, postman, path.getPost());
		}

		if (path.getGet() != null) {
			TemplateGet.generateTemplateGet(url, postman, path.getGet());
		}

		if (path.getDelete() != null) {
			TemplateDelete.generateTemplateDelete(url, postman, path.getDelete());
		}

		if (path.getPut() != null) {
			TemplateDelete.generateTemplateDelete(url, postman, path.getPut());
		}
	}

}
