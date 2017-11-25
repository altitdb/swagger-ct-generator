package com.matera.swagger.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.matera.swagger.model.Request;
import com.matera.swagger.model.Request.RequestBuilder;
import com.matera.swagger.model.domain.Domain;
import com.matera.swagger.model.swagger.Parameter;
import com.matera.swagger.model.swagger.Path;
import com.matera.swagger.model.swagger.Swagger;

public class RequestGenerator {

	private static final String HTTP_PROTOCOL = "http";
	private static final Logger LOG = LogManager.getRootLogger();

	public List<Request> getRequests(Swagger swagger, Domain domain) {
		List<Request> requests = new ArrayList<>();
		Map<String, Path> paths = swagger.getPaths();
		for (Map.Entry<String, Path> entry : paths.entrySet()) {
			LOG.info("Genering requests to uri {}", entry.getKey());
			Path path = entry.getValue();
			String baseUrl = swagger.getHost() + swagger.getBasePath();
			if (!baseUrl.startsWith(HTTP_PROTOCOL)) {
				baseUrl = String.format("http://%s", baseUrl);
			}

			Request request = new RequestBuilder().withName("").withBaseUrl(baseUrl).withUri(entry.getKey())
					.withMethod(path.getMethod()).build();
			LOG.info("Generated {}", request);
			requests.add(request);
		}
		LOG.info("{} generated", requests.size());
		return requests;
	}
}
