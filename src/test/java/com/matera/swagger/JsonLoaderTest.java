package com.matera.swagger;

import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class JsonLoaderTest {

	private static final String URL = "http://doc-api.matera.com/ibk_edge.json";
	private static final JsonLoader jsonLoader = new JsonLoader();
	
	@BeforeClass
	public static void setup() {
		jsonLoader.loader(URL);
	}
	
	@Test
	public void shouldReturnUriDomains() {
		Assert.assertEquals(jsonLoader.getUriDomain().size(), 59);
	}

	@Test
	public void shouldReturnHeaderDomains() {
		Assert.assertEquals(jsonLoader.getHeaderDomain().size(), 1);
	}
	
	@Test
	public void shouldReturnPathDomains() {
		Assert.assertEquals(jsonLoader.getPathDomain().size(), 4);
	}
	
	@Test
	public void shouldReturnQueryDomains() {
		Assert.assertEquals(jsonLoader.getQueryDomain().size(), 9);
	}
	
	@Test
	public void shouldReturnBodyDomains() {
		Assert.assertEquals(jsonLoader.getBodyDomain().size(), 51);
	}

}

