package com.matera.swagger.model;

import java.util.Set;

import com.google.gson.annotations.Expose;

public class Parameter {

	@Expose
	private String name;
	@Expose
	private String in;
	@Expose
	private String description;
	@Expose
	private boolean required;
	@Expose
	private String type;
	@Expose
	private Set<String> enums;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIn() {
		return in;
	}

	public void setIn(String in) {
		this.in = in;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<String> getEnums() {
		return enums;
	}

	public void setEnums(Set<String> enums) {
		this.enums = enums;
	}

}
