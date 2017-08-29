package com.matera.swagger.model;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;
import com.matera.swagger.model.Header;
import com.matera.swagger.model.Request;
import com.matera.swagger.model.Request.RequestBuilder;

import junit.framework.Assert;

public class RequestTest {

	private Request request;

	@Test
	public void shouldGetUri() {
		request = new RequestBuilder().withUri("/v1/my-first-uri").build();
		Assert.assertEquals("/v1/my-first-uri", request.getUri());
	}

	@Test
	public void shouldGetUrl() {
		request = new RequestBuilder().withUrl("http://localhost:8080/api").build();
		Assert.assertEquals("http://localhost:8080/api", request.getUrl());
	}
	
	@Test
	public void shouldGetOnlyOneHeader() {
		Header header = new Header("name", "value");
		request = new RequestBuilder().withHeaders(header).build();
		Assert.assertEquals(ImmutableSet.of(header), request.getHeaders());
	}
	
	@Test
	public void shouldGetManyHeaders() {
		Header headerOne = new Header("name", "value");
		Header headerTwo = new Header("name", "value");
		request = new RequestBuilder().withHeaders(headerOne, headerTwo).build();
		Assert.assertEquals(ImmutableSet.of(headerOne, headerTwo), request.getHeaders());
	}
}
