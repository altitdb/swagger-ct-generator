package com.matera.swagger.model.swagger;

import java.util.Map;

public class Swagger {

	private String swagger;
	private Info info;
	private String host;
	private String basePath;
	private Map<String, Path> paths;
	private Map<String, Definition> definitions;

	public String getSwagger() {
		return this.swagger;
	}

	public Info getInfo() {
		return this.info;
	}

	public String getHost() {
		return host;
	}

	public String getBasePath() {
		return basePath;
	}

	public Map<String, Path> getPaths() {
		return paths;
	}

	public Map<String, Definition> getDefinitions() {
		return definitions;
	}

}
