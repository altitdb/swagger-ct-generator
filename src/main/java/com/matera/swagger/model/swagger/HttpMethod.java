package com.matera.swagger.model.swagger;

import java.util.List;
import java.util.Set;

public class HttpMethod {

	private String operationId;

	private String summary;

	private Set<String> tags;

	private String description;

	private Set<String> produces;

	private List<Parameter> parameters;

	private Responses responses;

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<String> getProduces() {
		return produces;
	}

	public void setProduces(Set<String> produces) {
		this.produces = produces;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	public Responses getResponses() {
		return responses;
	}

	public void setResponses(Responses responses) {
		this.responses = responses;
	}

}
