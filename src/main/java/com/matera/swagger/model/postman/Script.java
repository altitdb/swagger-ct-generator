package com.matera.swagger.model.postman;

import java.util.Set;

public class Script {

	private String type;
	private Set<String> exec;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<String> getExec() {
		return exec;
	}

	public void setExec(Set<String> exec) {
		this.exec = exec;
	}

}
