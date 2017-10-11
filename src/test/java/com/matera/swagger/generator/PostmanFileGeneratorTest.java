package com.matera.swagger.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import com.matera.swagger.loader.SwaggerLoader;
import com.matera.swagger.model.postman.Postman;
import com.matera.swagger.model.swagger.Swagger;

public class PostmanFileGeneratorTest {

	private Swagger swagger;

	@Before
	public void setup() throws IOException {
		String json = new String(Files.readAllBytes(Paths.get("src/test/resources/test.json")));
		SwaggerLoader loader = new SwaggerLoader();
		swagger = loader.loader(json);
	}

	@Test
	public void shouldGeneratePostmanTemplate() {

		Postman postman = new Postman();

		PostmanFileGenerator.postmanFileGenerator(postman, swagger);

	}

}
