package com.matera.swagger.template.postman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.matera.swagger.loader.SwaggerLoader;
import com.matera.swagger.model.postman.Postman;
import com.matera.swagger.model.swagger.Swagger;

public class TemplateInfoTest {

	private Swagger swagger;

	@Before
	public void setup() throws IOException {
		String json = new String(Files.readAllBytes(Paths.get("src/test/resources/test.json")));
		SwaggerLoader loader = new SwaggerLoader();
		swagger = loader.loader(json);
	}

	@Test
	public void shouldGenerateInfoTemplate() {

		Postman postman = new Postman();

		TemplateInfo.generateTemplateInfo(postman, swagger);

		// Deve gerar o Info do arquivo
		Assert.assertNotNull(postman.getInfo());
		// Deve gerar o mesmo título do swagger no name do postman
		Assert.assertEquals(swagger.getInfo().getTitle(), postman.getInfo().getName());
	}

}
