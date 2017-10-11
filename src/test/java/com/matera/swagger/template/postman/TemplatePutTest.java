package com.matera.swagger.template.postman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.matera.swagger.loader.SwaggerLoader;
import com.matera.swagger.model.swagger.Path;
import com.matera.swagger.model.swagger.Swagger;

public class TemplatePutTest {

	private Swagger swagger;

	@Before
	public void setup() throws IOException {
		String json = new String(Files.readAllBytes(Paths.get("src/test/resources/test.json")));
		SwaggerLoader loader = new SwaggerLoader();
		swagger = loader.loader(json);
	}

	@Test
	public void shouldGeneratePutTemplate() {

		String url = "/v1/beneficiary/{branch}/{account}/{id}";
		Path path = swagger.getPaths().get(url);

		// Deve ser nulo por que não possui método PUT no path
		Assert.assertNull(path.getPut());

		// No arquivo de test não possue PUT
		// Postman postman = new Postman();
		// TemplatePut.generateTemplatePut(url, postman, path.getPut());

	}

}
