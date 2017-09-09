package com.matera.swagger.model.swagger;

import java.util.Objects;

public class Parameter {

	private String name;
	private String in;
	private String description;
	private Boolean required;
	private String type;
	private String format;

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

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, in, description, required, type, format);
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Parameter)) {
			return false;
		}
		Parameter castOther = (Parameter) other;
		return Objects.equals(name, castOther.name) && Objects.equals(in, castOther.in)
				&& Objects.equals(description, castOther.description) && Objects.equals(required, castOther.required)
				&& Objects.equals(type, castOther.type) && Objects.equals(format, castOther.format);
	}

}
