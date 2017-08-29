package com.matera.swagger.loader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JsonLoader {

	private static final Logger LOG = LogManager.getRootLogger();
	private String url;
	private String json;
		
	public String getUrl() {
		return this.url;
	}

	public void loader(String url) {
		LOG.info("Downloading URL {}", url);
		this.url = url;
		InputStream is = null;
		try {
			is = new URL(url).openStream();
		} catch (MalformedURLException e) {
			LOG.error("URL is not valid.", e);
		} catch (IOException e) {
			LOG.error("It wasn't possible to read the URL.", e);
		}
		try {
			this.json = IOUtils.toString(is, "UTF-8");
		} catch (IOException e) {
			LOG.error("The content is not available.", e);
		}
	}
	
	public String getJson() {
		return this.json;
	}
	
}