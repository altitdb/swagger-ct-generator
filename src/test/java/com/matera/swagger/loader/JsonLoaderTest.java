package com.matera.swagger.loader;

import org.junit.BeforeClass;
import org.junit.Test;

import com.matera.swagger.loader.JsonLoader;

import junit.framework.Assert;

public class JsonLoaderTest {

	private static final String URL = "http://doc-api.matera.com/ibk_edge.json";
	private static final JsonLoader jsonLoader = new JsonLoader();
	
	@BeforeClass
	public static void setup() {
		jsonLoader.loader(URL);
	}
	
	@Test
	public void shouldReturnTheUrl() {
		Assert.assertEquals(jsonLoader.getUrl(), URL);
	}
	
	@Test
	public void shouldContainsJson() {
		Assert.assertNotNull(jsonLoader.getJson());
	}
	
}

