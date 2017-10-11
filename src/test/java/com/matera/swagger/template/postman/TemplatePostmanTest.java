package com.matera.swagger.template.postman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.matera.swagger.loader.SwaggerLoader;
import com.matera.swagger.model.postman.Postman;
import com.matera.swagger.model.swagger.Path;
import com.matera.swagger.model.swagger.Swagger;

public class TemplatePostmanTest {

	private Swagger swagger;

	@Before
	public void setup() throws IOException {
		String json = new String(Files.readAllBytes(Paths.get("src/test/resources/test.json")));
		SwaggerLoader loader = new SwaggerLoader();
		swagger = loader.loader(json);
	}

	@Test
	public void shouldGeneratePostmanTemplate() {

		String url = "/v1/beneficiary/{branch}/{account}/{id}";
		Path path = swagger.getPaths().get(url);

		Postman postman = new Postman();

		TemplatePost.generateTemplatePost(url, postman, path.getPost());
		TemplateGet.generateTemplateGet(url, postman, path.getGet());
		TemplateDelete.generateTemplateDelete(url, postman, path.getDelete());

		// Deve gerar o Item para uma classe que estava nula
		Assert.assertNotNull(postman.getItem());
		// Deve checar se gerou is 3 Item (a URL possui apenas 1 Item no
		// arquivo swagger)
		Assert.assertEquals(3, postman.getItem().size());

	}

}
