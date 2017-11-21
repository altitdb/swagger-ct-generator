package com.matera.swagger.generator;

import org.junit.Test;

public class PostmanFileGeneratorTest {

	@Test
	public void shouldGeneratePostmanTemplate() {
		new PostmanFileGenerator().generate(null);
	}

}
