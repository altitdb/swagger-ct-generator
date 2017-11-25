package com.matera.swagger.model.swagger;

import org.junit.Test;

import junit.framework.Assert;

public class PathTest {

	@Test
	public void shouldReturnMethodGet() {
		Path path = new Path();
		path.setGet(new HttpMethod());
		Assert.assertEquals("GET", path.getMethod());
	}
	
	@Test
	public void shouldReturnMethodPost() {
		Path path = new Path();
		path.setPost(new HttpMethod());
		Assert.assertEquals("POST", path.getMethod());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenMethodNotExists() {
		Path path = new Path();
		path.getMethod();
	}
	
	@Test
	public void shouldReturnMethodPut() {
		Path path = new Path();
		path.setPut(new HttpMethod());
		Assert.assertEquals("PUT", path.getMethod());
	}
	
	@Test
	public void shouldReturnMethodDelete() {
		Path path = new Path();
		path.setDelete(new HttpMethod());
		Assert.assertEquals("DELETE", path.getMethod());
	}

}
