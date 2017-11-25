package com.matera.swagger.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.matera.swagger.loader.SwaggerLoader;
import com.matera.swagger.model.Request;
import com.matera.swagger.model.domain.Domain;
import com.matera.swagger.model.swagger.Swagger;

public class RequestGeneratorTest {
	
	private Swagger swagger;
	
	private Domain domain;

	@Before
	public void setup() throws IOException {
		String json = new String(Files.readAllBytes(Paths.get("src/test/resources/test.json")));
		SwaggerLoader loader = new SwaggerLoader();
		swagger = loader.loader(json);
	}

	@Test
	public void shouldGenerateFirstRequest() {
		RequestGenerator generator = new RequestGenerator();
		List<Request> requests = generator.getRequests(swagger, domain);
		Assert.assertEquals(59, requests.size());
	}

}
