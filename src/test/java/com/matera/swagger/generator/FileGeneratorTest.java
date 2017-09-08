package com.matera.swagger.generator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.matera.swagger.template.PostmanTemplate;

public class FileGeneratorTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void shouldValidatePath() {
		FileGenerator fileGenerator = new FileGenerator();
		fileGenerator.generateFile(null, new PostmanTemplate());
	}
}
