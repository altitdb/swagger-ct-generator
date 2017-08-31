package com.matera.swagger.model;

public class PathParam {

	private String name;
	private String value;

	public PathParam(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

}
