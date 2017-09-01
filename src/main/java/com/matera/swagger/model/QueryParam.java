package com.matera.swagger.model;

public class QueryParam {

	private String name;
	private String value;

	public QueryParam(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public String getQuery() {
		return String.format("%s=%s", name, value);
	}

}
