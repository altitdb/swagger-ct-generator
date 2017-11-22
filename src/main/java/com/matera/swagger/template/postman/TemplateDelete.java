package com.matera.swagger.template.postman;

import java.util.ArrayList;
import java.util.List;

import com.matera.swagger.model.postman.Body;
import com.matera.swagger.model.postman.HeaderPostman;
import com.matera.swagger.model.postman.Item;
import com.matera.swagger.model.postman.Postman;
import com.matera.swagger.model.postman.RequestPostman;
import com.matera.swagger.model.swagger.HttpMethod;
import com.matera.swagger.model.swagger.Parameter;

public class TemplateDelete {

	public static final String DELETE = "DELETE";

	public static void generateTemplateDelete(String url, Postman postman, HttpMethod postSwagger) {

		RequestPostman request = new RequestPostman();
		request.setUrl(url);
		request.setMethod(DELETE);

		List<HeaderPostman> headers = new ArrayList<>();

		if (postSwagger.getParameters() != null) {

			for (Parameter parameter : postSwagger.getParameters()) {

				if (parameter.getIn().equals("header")) {

					HeaderPostman header = new HeaderPostman();
					header.setKey(parameter.getName());
					header.setValue("");
					header.setDescription(parameter.getDescription());
					headers.add(header);
				}
			}
		}
		
		request.setHeader(headers);

		Body body = new Body();
		request.setBody(body);

		String descriptionRequest = postSwagger.getDescription();
		request.setDescription(descriptionRequest);

		Item item = new Item();
		item.setName(postSwagger.getSummary());
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
