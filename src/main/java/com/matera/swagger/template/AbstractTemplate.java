package com.matera.swagger.template;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.matera.swagger.model.Parameter;

public abstract class AbstractTemplate {

	@Expose
	private String operationId;
	
	@Expose
	private String summary;
	
	@Expose
	private List<String> tags;
	
	@Expose
	private String description;
	
	@Expose
	private List<String> produces;
	
	@Expose
	private List<Parameter> parameters;
	
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

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getProduces() {
		return produces;
	}

	public void setProduces(List<String> produces) {
		this.produces = produces;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}
	
	

}
