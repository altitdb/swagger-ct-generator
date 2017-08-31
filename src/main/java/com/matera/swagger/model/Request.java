package com.matera.swagger.model;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

public class Request {

	private String url;
	private String uri;
	private Set<Header> headers;
	private Set<PathParam> pathParams;
	private Set<QueryParam> queryParams;
	private String body;

	public String getUri() {
		return this.uri;
	}

	public String getUrl() {
		return this.url;
	}

	public Set<Header> getHeaders() {
		return this.headers;
	}
	
	public Set<PathParam> getPathParams() {
		return this.pathParams;
	}
	
	public Set<QueryParam> getQueryParams() {
		return this.queryParams;
	}
	
	public String getBody() {
		return this.body;
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

		public RequestBuilder withPathParam(PathParam... pathParam) {
			request.pathParams = ImmutableSet.copyOf(pathParam);
			return this;
		}

		public RequestBuilder withQueryParam(QueryParam... queryParam) {
			request.queryParams = ImmutableSet.copyOf(queryParam);
			return this;
		}

		public RequestBuilder withBody(String body) {
			request.body = body;
			return this;
		}
	}

}
