package com.matera.swagger.model.csv;

public class Domain {

	private String domainName;
	private String paramValue;
	private String response;

	public Domain(){}
	
	public Domain(String domainName, String paramValue, String response) {
		this.domainName = domainName;
		this.paramValue = paramValue;
		this.response = response;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
