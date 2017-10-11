package com.matera.swagger.template.postman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.matera.swagger.loader.SwaggerLoader;
import com.matera.swagger.model.postman.Postman;
import com.matera.swagger.model.swagger.Path;
import com.matera.swagger.model.swagger.Swagger;

public class TemplateDeleteTest {

	private Swagger swagger;

	@Before
	public void setup() throws IOException {
		String json = new String(Files.readAllBytes(Paths.get("src/test/resources/test.json")));
		SwaggerLoader loader = new SwaggerLoader();
		swagger = loader.loader(json);
	}

	@Test
	public void shouldGenerateDeleteTemplate() {

		String url = "/v1/beneficiary/{branch}/{account}/{id}";
		Path path = swagger.getPaths().get(url);

		Postman postman = new Postman();

		TemplateDelete.generateTemplateDelete(url, postman, path.getDelete());

		// Deve gerar o Item para uma classe que estava nula
		Assert.assertNotNull(postman.getItem());
		// Deve checar se gerou apenas 1 Item (a URL possui apenas 1 Item no
		// arquivo swagger)
		Assert.assertEquals(1, postman.getItem().size());
		// Deve checar se gerou apenas 1 parametro no header (a URL possui
		// apenas 1 parameters)
		Assert.assertEquals(1, postman.getItem().get(0).getRequest().getHeader().size());
		// Deve checar se gerou o nome do header igual ao nome do parameters do
		// swagger
		Assert.assertEquals(path.getDelete().getParameters().get(0).getName(),
				postman.getItem().get(0).getRequest().getHeader().get(0).getKey());

	}

}
