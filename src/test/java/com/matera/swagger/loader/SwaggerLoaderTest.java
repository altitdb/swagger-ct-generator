package com.matera.swagger.loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import com.matera.swagger.model.swagger.Info;
import com.matera.swagger.model.swagger.Swagger;

import junit.framework.Assert;

public class SwaggerLoaderTest {

	private Swagger swagger;
	
	@Before
	public void setup() throws IOException {
		String json = new String(Files.readAllBytes(Paths.get("src/test/resources/test.json")));
		SwaggerLoader loader = new SwaggerLoader();
		swagger = loader.loader(json);
	}
	@Test
	public void shouldReturnVersion() {
		Assert.assertEquals("2.0", swagger.getSwagger());
	}
	
	@Test
	public void shouldReturnInfo() {
		Info info = new Info();
		info.setVersion("1");
		info.setTitle("Internet Banking");
		info.setDescription("APIs REST do sistema de Internet Banking da MATERA Systems.");
		Assert.assertEquals(info, swagger.getInfo());
	}
	
	@Test
	public void shouldReturnHost() {
		Assert.assertEquals("api-ibk.matera.com.br", swagger.getHost());
	}
	
	@Test
	public void shouldReturnBasePath() {
		Assert.assertEquals("/api", swagger.getBasePath());
	}
	
	@Test
	public void shouldReturnPaths() {
		Assert.assertNotNull(swagger.getPaths());
	}
	
	@Test
	public void shouldReturnDefinitions() {
		Assert.assertNotNull(swagger.getDefinitions());
	}

}

