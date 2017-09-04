package com.matera.swagger.template;

import java.util.Set;

public class TemplatePost extends Template {

	private Set<String> consumes; 
	
	public TemplatePost(){}

	public Set<String> getConsumes() {
		return consumes;
	}

	public void setConsumes(Set<String> consumes) {
		this.consumes = consumes;
	}
	
}
