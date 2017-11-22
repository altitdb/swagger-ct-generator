package com.matera.swagger.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.matera.swagger.loader.SwaggerLoader;
import com.matera.swagger.model.Request;
import com.matera.swagger.model.swagger.Swagger;

public class PostmanFileGeneratorTest {

	private Swagger swagger;
	
	private List<Request> request;

	@Before
	public void setup() throws IOException {

		String json = new String(Files.readAllBytes(Paths.get("src/test/resources/test.json")));
		SwaggerLoader loader = new SwaggerLoader();

		swagger = loader.loader(json);

		request = RequestGenerator.getRequests(swagger);
	}

	@Test
	public void shouldGeneratePostmanTemplate() {
		new PostmanFileGenerator().generate(request, swagger.getInfo());
	}

}
