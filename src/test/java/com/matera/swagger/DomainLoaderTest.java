package com.matera.swagger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class DomainLoaderTest {

	private static final DomainLoader domainLoader = new DomainLoader();
	
	@BeforeClass
	public static void setup() throws IOException {
		String json = new String(Files.readAllBytes(Paths.get("src/test/resources/test.json")));
		domainLoader.loader(json);
	}
	
	@Test
	public void shouldReturnUriDomains() {
		Assert.assertEquals(domainLoader.getUriDomain().size(), 59);
	}

	@Test
	public void shouldReturnHeaderDomains() {
		Assert.assertEquals(domainLoader.getHeaderDomain().size(), 1);
	}
	
	@Test
	public void shouldReturnPathDomains() {
		Assert.assertEquals(domainLoader.getPathDomain().size(), 4);
	}
	
	@Test
	public void shouldReturnQueryDomains() {
		Assert.assertEquals(domainLoader.getQueryDomain().size(), 9);
	}
	
	@Test
	public void shouldReturnBodyDomains() {
		Assert.assertEquals(domainLoader.getBodyDomain().size(), 51);
	}

}

