package com.matera.swagger.template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.matera.swagger.model.postman.InfoPostman;
import com.matera.swagger.model.postman.ItemPostman;
import com.matera.swagger.model.postman.VariablePostman;

public class TemplateFilePostman {

	private List<VariablePostman> variables;

	private InfoPostman info;

	private List<ItemPostman> item;

	public List<VariablePostman> getVariables() {
		return variables;
	}

	public void setVariables(List<VariablePostman> variables) {
		this.variables = variables;
	}

	public InfoPostman getInfo() {
		return info;
	}

	public void setInfo(InfoPostman info) {
		this.info = info;
	}

	public List<ItemPostman> getItem() {
		return item;
	}

	public void setItem(List<ItemPostman> item) {
		this.item = item;
	}

	public void generateFile(TemplateFilePostman templateFile) {

		File file = new File("");

		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			writer.write("{");
			writer.newLine();
			writer.write("	'variables': ");
			// Sobrescrever o método toString do objeto para o template padrão
			// do postman
			writer.write(templateFile.getVariables().toString());
			writer.newLine();
			writer.write("	'info': {");
			writer.newLine();
			// Sobrescrever o método toString do objeto para o template padrão
			// do postman
			writer.write(templateFile.getInfo().toString());
			writer.newLine();
			writer.write("	},");
			writer.newLine();
			writer.write("	'item': [");
			writer.newLine();
			// Sobrescrever o método toString do objeto para o template padrão
			// do postman
			writer.write(templateFile.getItem().toString());
			writer.newLine();
			writer.write("	]");
			writer.newLine();
			writer.write("}");

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
