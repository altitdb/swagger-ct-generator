package com.matera.swagger.model.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class DomainTest {

	@Test
	public void shouldAddNewDomain() {
		Domain domain = new Domain();
		domain.add("key", "value", 200);
		Assert.assertSame(1, domain.getDomainsFromKey("key"));
	}
	
	@Test
	public void shouldReturnZeroFromInexistentDomain() {
		Domain domain = new Domain();
		domain.add("key", "value", 200);
		Assert.assertSame(0, domain.getDomainsFromKey("key1"));
	}
	
	@Test
	public void shouldAddNewDomainWithTheSameKey() {
		Domain domain = new Domain();
		domain.add("key", "value", 200);
		domain.add("key", "value", 200);
		Assert.assertSame(1, domain.getDomainsFromKey("key"));
	}
	
	@Test
	public void shouldAddNewDomainWithTheSameKeyAndResult() {
		Domain domain = new Domain();
		domain.add("key", "value", 200);
		domain.add("key", "value", 200);
		Assert.assertSame(1, domain.getDomainsFromKey("key"));
	}
	
	@Test
	public void shouldAddNewDomainWithTheSameKeyAndManyResults() {
		Domain domain = new Domain();
		domain.add("key", "value", 200);
		domain.add("key", "otherValue", 400);
		domain.add("key", "wrongValue", 500);
		Assert.assertSame(3, domain.getDomainsFromKey("key"));
	}
	
	@Test
	public void shouldGetSuccessValueFromDomain() {
		Domain domain = new Domain();
		domain.add("key", "value", 200);
		domain.add("key", "otherValue", 400);
		domain.add("key", "wrongValue", 500);
		Assert.assertEquals("value", domain.getSuccess("key"));
	}
	
	@Test
	public void shouldGetWrongValuesFromDomain() {
		Domain domain = new Domain();
		domain.add("key", "value", 200);
		domain.add("key", "otherValue", 400);
		domain.add("key", "wrongValue", 500);
		List<Object> expected = Arrays.asList("otherValue", "wrongValue");
		Assert.assertEquals(expected, domain.getError("key"));
	}


}
