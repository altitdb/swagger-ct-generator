package com.matera.swagger.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.common.collect.ImmutableSet;
import com.matera.swagger.model.Request.RequestBuilder;

import junit.framework.Assert;

public class RequestTest {

	private Request request;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void shouldGetUri() {
		request = new RequestBuilder().withBaseUrl("http://localhost:8080").withUri("/api/v1/my-first-uri").build();
		Assert.assertEquals("/api/v1/my-first-uri", request.getUri());
	}

	@Test
	public void shouldGetBaseUrl() {
		request = new RequestBuilder().withBaseUrl("http://localhost:8080").withUri("/api/v1/my-first-uri").build();
		Assert.assertEquals("http://localhost:8080", request.getBaseUrl());
	}
	
	@Test
	public void shouldGetOnlyOneHeader() {
		Header header = new Header("name", "value");
		request = new RequestBuilder().withBaseUrl("http://localhost:8080").withUri("/api/v1/my-first-uri").withHeaders(header).build();
		Assert.assertEquals(ImmutableSet.of(header), request.getHeaders());
	}
	
	@Test
	public void shouldGetManyHeaders() {
		Header headerOne = new Header("name", "value");
		Header headerTwo = new Header("name", "value");
		request = new RequestBuilder().withBaseUrl("http://localhost:8080").withUri("/api/v1/my-first-uri").withHeaders(headerOne, headerTwo).build();
		Assert.assertEquals(ImmutableSet.of(headerOne, headerTwo), request.getHeaders());
	}
	
	@Test
	public void shouldGetOnlyOnePathParam() {
		PathParam pathParam = new PathParam("name", "value");
		request = new RequestBuilder().withBaseUrl("http://localhost:8080").withUri("/api/v1/my-first-uri/{name}").withPathParam(pathParam).build();
		Assert.assertEquals(ImmutableSet.of(pathParam), request.getPathParams());
	}
	
	@Test
	public void shouldGetManyPathParam() {
		PathParam pathParamOne = new PathParam("param-one", "param-one-value");
		PathParam pathParamTwo = new PathParam("param-two", "param-two-value");
		request = new RequestBuilder().withBaseUrl("http://localhost:8080").withUri("/api/v1/my-first-uri/{param-one}/{param-two}").withPathParam(pathParamOne, pathParamTwo).build();
		Assert.assertEquals(ImmutableSet.of(pathParamOne, pathParamTwo), request.getPathParams());
	}
	
	@Test
	public void shouldGetOnlyOneQueryParam() {
		QueryParam queryParam = new QueryParam("name", "value");
		request = new RequestBuilder().withBaseUrl("http://localhost:8080").withUri("/api/v1/my-first-uri").withQueryParam(queryParam).build();
		Assert.assertEquals(ImmutableSet.of(queryParam), request.getQueryParams());
	}
	
	@Test
	public void shouldGetManyQueryParam() {
		QueryParam queryParamOne = new QueryParam("name", "value");
		QueryParam queryParamTwo = new QueryParam("name", "value");
		request = new RequestBuilder().withBaseUrl("http://localhost:8080").withUri("/api/v1/my-first-uri").withQueryParam(queryParamOne, queryParamTwo).build();
		Assert.assertEquals(ImmutableSet.of(queryParamOne, queryParamTwo), request.getQueryParams());
	}
	
	@Test
	public void shouldGetBody() {
		String json = "{\"key\":\"value\"}";
		request = new RequestBuilder().withBaseUrl("http://localhost:8080").withUri("/api/v1/my-first-uri").withBody(json).build();
		Assert.assertEquals(json, request.getBody());
	}
	
	@Test
	public void shouldGetUrl() {
		request = new RequestBuilder().withBaseUrl("http://localhost:8080").withUri("/api/v1/my-first-uri").build();
		Assert.assertEquals("http://localhost:8080/api/v1/my-first-uri", request.getUrl());
	}
	
	@Test
	public void shouldValidateMandatoryBashUrl() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("The baseUrl value cannot be null or empty.");
		request = new RequestBuilder().withUri("/api/v1/my-first-uri").build();
	}
	
	@Test
	public void shouldValidateMandatoryUri() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("The uri value cannot be null or empty.");
		request = new RequestBuilder().withBaseUrl("http://localhost:8080").build();
	}
	
	@Test
	public void shouldParsePathParams() {
		PathParam pathParam = new PathParam("some-param", "some-param-value");
		request = new RequestBuilder().withBaseUrl("http://localhost:8080").withUri("/api/v1/my-first-uri/{some-param}").withPathParam(pathParam).build();
		Assert.assertEquals("http://localhost:8080/api/v1/my-first-uri/some-param-value", request.getUrl());
	}
	
	@Test
	public void shouldValidateAmountPathParams() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("The path param {some-param} was not aware in uri.");
		PathParam pathParam = new PathParam("some-param", "some-param-value");
		request = new RequestBuilder().withBaseUrl("http://localhost:8080").withUri("/api/v1/my-first-uri").withPathParam(pathParam).build();
	}
	
	@Test
	public void shouldFormatUrlWithQueryParam() {
		QueryParam queryParam = new QueryParam("name", "value");
		request = new RequestBuilder().withBaseUrl("http://localhost:8080").withUri("/api/v1/my-first-uri").withQueryParam(queryParam).build();
		Assert.assertEquals("http://localhost:8080/api/v1/my-first-uri?name=value", request.getUrl());
	}
	
	@Test
	public void shouldFormatUrlWithManyQueryParam() {
		QueryParam queryParamOne = new QueryParam("name-one", "value-one");
		QueryParam queryParamTwo = new QueryParam("name-two", "value-two");
		request = new RequestBuilder().withBaseUrl("http://localhost:8080").withUri("/api/v1/my-first-uri").withQueryParam(queryParamOne, queryParamTwo).build();
		Assert.assertEquals("http://localhost:8080/api/v1/my-first-uri?name-one=value-one&name-two=value-two", request.getUrl());
	}
	
}
