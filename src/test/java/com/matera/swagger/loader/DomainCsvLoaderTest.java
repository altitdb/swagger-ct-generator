package com.matera.swagger.loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import com.matera.swagger.model.swagger.Parameter;
import com.matera.swagger.model.swagger.Path;
import com.matera.swagger.model.swagger.Swagger;

import junit.framework.Assert;

public class DomainCsvLoaderTest {

	private Swagger swagger;
	
	private DomainCsvLoader domainCsvLoader;
	
	@Before
	public void setup() throws IOException {
		String csvFile = "src/test/resources/domain.csv";
		domainCsvLoader = new DomainCsvLoader();
		domainCsvLoader.loader(csvFile);
		
		String json = new String(Files.readAllBytes(Paths.get("src/test/resources/test.json")));
		SwaggerLoader loader = new SwaggerLoader();
		swagger = loader.loader(json);
		
	}
	
	@Test
	public void shouldReturnSizeTwo() throws IOException {
		Assert.assertEquals(2, domainCsvLoader.getCsvDomains().size());
	}
	
	@Test
	public void shouldReturn400() throws IOException {
		Assert.assertEquals("400", domainCsvLoader.getCsvDomains().get("branch").get("-1"));
	}
	
	@Test
	public void shouldReturn200() throws IOException {
		Assert.assertEquals("200", domainCsvLoader.getCsvDomains().get("account").get("1"));
	}
	
	
	@Test
	public void shouldReturn200UsingSwaggerLoader() throws IOException {
		Path path = swagger.getPaths().get("/v1/account/balance/{branch}/{account}");
		Assert.assertEquals("200", domainCsvLoader.getCsvDomains().get(path.getParameters().get(0).getName()).get("50"));
	}
	
	@Test
	public void shouldReturn400UsingParameter() throws IOException {
		
		Parameter parameter = new Parameter();
		parameter.setName("branch");
		parameter.setIn("path");
		parameter.setDescription("Branch");
		parameter.setRequired(true);
		parameter.setType("integer");
		parameter.setFormat("int32");

		Assert.assertEquals("400", domainCsvLoader.getCsvDomains().get(parameter.getName()).get("nelson"));
	}

}
