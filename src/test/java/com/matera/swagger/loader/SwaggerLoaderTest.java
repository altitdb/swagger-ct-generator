package com.matera.swagger.loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import com.matera.swagger.model.swagger.HttpMethod;
import com.matera.swagger.model.swagger.Info;
import com.matera.swagger.model.swagger.Parameter;
import com.matera.swagger.model.swagger.Path;
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
	
	@Test
	public void shouldReturnParameters() {
		Path path = swagger.getPaths().get("/v1/account/balance/{branch}/{account}");
		Assert.assertNotNull(path.getParameters());
	}
	
	@Test
	public void shouldReturnAmountParameters() {
		Path path = swagger.getPaths().get("/v1/account/balance/{branch}/{account}");
		Assert.assertEquals(2, path.getParameters().size());
	}

	@Test
	public void shouldReturnParameterValues() {
		Path path = swagger.getPaths().get("/v1/account/balance/{branch}/{account}");
		Parameter actual = path.getParameters().get(0);
		Parameter parameter = new Parameter();
		parameter.setName("branch");
		parameter.setIn("path");
		parameter.setDescription("Branch");
		parameter.setRequired(true);
		parameter.setType("integer");
		parameter.setFormat("int32");
		Assert.assertEquals(parameter, actual);
	}
	
	@Test
	public void shouldReturnGetMethod() {
		Path path = swagger.getPaths().get("/v1/account/balance/{branch}/{account}");
		HttpMethod method = path.getGet();
		Assert.assertNotNull(method);
	}
	
	@Test
	public void shouldReturnPostMethod() {
		Path path = swagger.getPaths().get("/v1/scheduling/cancel/{id}");
		HttpMethod method = path.getPost();
		Assert.assertNotNull(method);
	}

}

