package com.matera.swagger.generator;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.matera.swagger.model.postman.Postman;

public class FileGenerator {

	private static final Logger LOG = LogManager.getRootLogger();
	
	public static void generateFile(String path, Postman template) {
		Gson gson = new Gson();
		String json = gson.toJson(template);
		if (StringUtils.isBlank(path)) {
			path = System.getProperty("user.dir");
		}
		String date = getFormattedDate();
		path = StringUtils.join(path, "/", date, ".json");
		LOG.info("Generating file {}", path);
		FileWriter file = null;
		try {
			file = new FileWriter(path);
			file.write(json);
		} catch (IOException e) {
			LOG.info("Error in generate file.", e);
		} finally {
			if (file != null) {
				IOUtils.closeQuietly(file);
			}
		}
		
	}

	private static String getFormattedDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return simpleDateFormat.format(new Date());
	}
}
