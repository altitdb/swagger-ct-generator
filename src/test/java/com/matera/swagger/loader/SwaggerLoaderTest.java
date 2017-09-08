package com.matera.swagger.loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import com.matera.swagger.model.swagger.Swagger;

import junit.framework.Assert;

public class SwaggerLoaderTest {

	@Test
	public void shouldReadSwaggerFromJson() throws IOException {
		String json = new String(Files.readAllBytes(Paths.get("src/test/resources/test.json")));
		SwaggerLoader loader = new SwaggerLoader();
		Swagger swagger = loader.loader(json);
		Assert.assertNotNull("2.0", swagger.getSwagger());
	}

}

