package com.matera.swagger.generator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.matera.swagger.model.Request;
import com.matera.swagger.model.Request.RequestBuilder;
import com.matera.swagger.model.domain.Domain;
import com.matera.swagger.model.swagger.Swagger;

public class RequestGenerator {

	public List<Request> getRequests(Swagger swagger, Domain domain) {
		List<Request> requests = new ArrayList<>();
		Iterator<String> iterator = swagger.getPaths().keySet().iterator();
		while (iterator.hasNext()) {
			String uri = iterator.next();
			Request request = new RequestBuilder().withName("").withBaseUrl("http://localhost:8080").withUri(uri)
					.withMethod("GET").build();
			requests.add(request);
		}
		return requests;
	}
}
