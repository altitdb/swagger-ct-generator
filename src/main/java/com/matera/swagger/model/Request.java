package com.matera.swagger.model;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

public class Request {

	private static final String METHOD_DELETE = "DELETE";
	private static final String METHOD_PUT = "PUT";
	private static final String METHOD_POST = "POST";
	private static final String METHOD_GET = "GET";
	
	private String name;
	private String method;
	private String uri;
	private String baseUrl;
	private String url;
	private Set<Header> headers = ImmutableSet.of();
	private Set<PathParam> pathParams = ImmutableSet.of();
	private Set<QueryParam> queryParams = ImmutableSet.of();
	private String body;

	public String getName() {
		return this.name;
	}
	
	public String getMethod(){
		return this.method;
	}
	
	public String getUri() {
		return this.uri;
	}

	public String getBaseUrl() {
		return this.baseUrl;
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
		
		public Request build() {
			request.buildUrl();
			request.validateBaseUrl();
			request.validateUri();
			request.validatePathParam();
			request.validateMethod();
			request.validateBody();
			request.parsePathParam();
			request.parseQueryParam();
			return request;
		}

		public RequestBuilder withUri(String uri) {
			request.uri = uri;
			return this;
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

		public RequestBuilder withBaseUrl(String baseUrl) {
			request.baseUrl = baseUrl;
			return this;
		}

		public RequestBuilder withName(String name) {
			request.name = name;
			return this;
		}

		public RequestBuilder withMethod(String method) {
			request.method = method;
			return this;
		}
	}

	private void buildUrl() {
		this.url = StringUtils.join(this.baseUrl, this.uri);
	}

	public void validateBody() {
		boolean isGet = isGet();
		boolean hasBody = StringUtils.isNotBlank(this.body);
		if (isGet && hasBody) {
			throw new IllegalArgumentException("The field body does not must be informed with GET method.");
		}
	}

	private void validateMethod() {
		mandatoryMethod();
		validMethod();
	}

	private void validMethod() {
		boolean contains = ImmutableSet.of(METHOD_GET, METHOD_POST, METHOD_PUT, METHOD_DELETE).contains(this.method);
		if (!contains) {
			throw new IllegalArgumentException("The method is not available in request.");
		}
	}

	private void mandatoryMethod() {
		if (StringUtils.isBlank(this.method)) {
			throw new IllegalArgumentException("The field method is mandatory.");
		}
	}

	private void parseQueryParam() {
		if (!this.queryParams.isEmpty()) {
			this.url = StringUtils.join(this.url, "?");
			QueryParam last = Iterables.getLast(queryParams);
			for (QueryParam queryParam : queryParams) {
				this.url = StringUtils.join(this.url, queryParam.getQuery());
				if (!queryParam.equals(last)) {
					this.url = StringUtils.join(this.url, "&");
				}
			}
		}
	}

	private void validatePathParam() {
		for (PathParam pathParam : pathParams) {
			String search = String.format("{%s}", pathParam.getName());
			boolean contains = StringUtils.contains(this.uri, search);
			if (!contains) {
				String message = String.format("The path param %s was not aware in uri.", search);
				throw new IllegalArgumentException(message);
			}
		}
	}

	private void parsePathParam() {
		for (PathParam pathParam : pathParams) {
			String replace = String.format("\\{%s\\}", pathParam.getName());
			this.url = StringUtils.replaceAll(this.url, replace, pathParam.getValue());
		}
	}

	private void validateBaseUrl() {
		if (StringUtils.isBlank(this.baseUrl)) {
			throw new IllegalArgumentException("The baseUrl value cannot be null or empty.");
		}		
	}
	
	private void validateUri() {
		if (StringUtils.isBlank(this.uri)) {
			throw new IllegalArgumentException("The uri value cannot be null or empty.");
		}		
	}

	public boolean isGet() {
		return METHOD_GET.equalsIgnoreCase(this.method);
	}

	public boolean isPost() {
		return METHOD_POST.equalsIgnoreCase(this.method);
	}

	public boolean isPut() {
		return METHOD_PUT.equalsIgnoreCase(this.method);
	}

	public boolean isDelete() {
		return METHOD_DELETE.equalsIgnoreCase(this.method);
	}

}
