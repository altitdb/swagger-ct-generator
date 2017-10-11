package com.matera.swagger.template.postman;

import java.util.ArrayList;
import java.util.List;

import com.matera.swagger.model.postman.Body;
import com.matera.swagger.model.postman.Header;
import com.matera.swagger.model.postman.Item;
import com.matera.swagger.model.postman.Postman;
import com.matera.swagger.model.postman.Request;
import com.matera.swagger.model.swagger.HttpMethod;
import com.matera.swagger.model.swagger.Parameter;

public class TemplateGet {

	private static final String MODE = "raw";
	public static final String GET = "GET";

	public static void generateTemplateGet(String url, Postman postman, HttpMethod postSwagger) {

		Request request = new Request();
		request.setUrl(url);
		request.setMethod(GET);

		List<Header> headers = new ArrayList<>();

		for (Parameter parameter : postSwagger.getParameters()) {

			if (parameter.getIn().equals("header")) {

				Header header = new Header();
				header.setKey(parameter.getName());
				header.setValue("");
				header.setDescription(parameter.getDescription());
				headers.add(header);
			}
		}

		request.setHeader(headers);

		Body body = new Body();
		body.setMode(MODE);
		body.setRaw("");

		request.setBody(body);

		String descriptionRequest = postSwagger.getDescription();
		request.setDescription(descriptionRequest);

		Item item = new Item();
		item.setName("");
		item.setRequest(request);

		if (postman.getItem() == null) {
			List<Item> itemPostman = new ArrayList<>();
			itemPostman.add(item);
			postman.setItem(itemPostman);
		} else {
			postman.getItem().add(item);
		}

	}

}
