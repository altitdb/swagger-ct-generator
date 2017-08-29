package com.matera.swagger.model;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

public class Request {

	private String url;
	private String uri;
	private Set<Header> headers;

	public String getUri() {
		return this.uri;
	}

	public String getUrl() {
		return this.url;
	}

	public Set<Header> getHeaders() {
		return headers;
	}

	public static class RequestBuilder {

		private Request request = new Request();

		public RequestBuilder withUrl(String url) {
			request.url = url;
			return this;
		}

		public RequestBuilder withUri(String uri) {
			request.uri = uri;
			return this;
		}

		public Request build() {
			return request;
		}

		public RequestBuilder withHeaders(Header... header) {
			request.headers = ImmutableSet.copyOf(header);
			return this;
		}
	}

}
