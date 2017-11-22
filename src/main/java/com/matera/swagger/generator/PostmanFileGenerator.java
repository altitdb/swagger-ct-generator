package com.matera.swagger.generator;

import java.util.ArrayList;
import java.util.List;

import com.matera.swagger.model.Header;
import com.matera.swagger.model.Request;
import com.matera.swagger.model.postman.Body;
import com.matera.swagger.model.postman.HeaderPostman;
import com.matera.swagger.model.postman.InfoPostman;
import com.matera.swagger.model.postman.Item;
import com.matera.swagger.model.postman.Postman;
import com.matera.swagger.model.postman.RequestPostman;
import com.matera.swagger.model.postman.Response;
import com.matera.swagger.model.postman.Variable;
import com.matera.swagger.model.swagger.Info;

public class PostmanFileGenerator {

	public void generate(List<Request> requests, Info info) {

		// TODO Receive requests

		List<Variable> variables = new ArrayList<>();

		InfoPostman infoPostman = new InfoPostman();
		infoPostman.setName(info.getTitle());
		infoPostman.set_postman_id("");
		infoPostman.setDescription(info.getDescription());
		infoPostman.setSchema("https://schema.getpostman.com/json/collection/v2.0.0/collection.json");

		List<Item> items = new ArrayList<>();

		for (Request request : requests) {

			Item item = new Item();

			item.setName(request.getName());

			RequestPostman requestPostman = new RequestPostman();

			requestPostman.setUrl(request.getUrl());

			requestPostman.setMethod(request.getMethod());

			List<HeaderPostman> headers = new ArrayList<>();

			for (Header header : request.getHeaders()) {

				HeaderPostman headerPostman = new HeaderPostman();
				headerPostman.setKey(header.getName());
				headerPostman.setValue(header.getValue());
				headerPostman.setDescription("");
				headers.add(headerPostman);
			}

			requestPostman.setHeader(headers);

			Body body = new Body();
			requestPostman.setBody(body);

			requestPostman.setDescription("");

			item.setRequest(requestPostman);

			List<Response> responses = new ArrayList<>();

			item.setResponse(responses);

			items.add(item);
		}

		// TODO Generate postman with template

		Postman postman = new Postman();

		postman.setVariables(variables);
		postman.setInfo(infoPostman);
		postman.setItem(items);

		FileGenerator.generateFile("", postman);
	}

}
