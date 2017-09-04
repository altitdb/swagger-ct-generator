package com.matera.swagger.template;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
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

		Gson gson = new Gson();
		
		String json = gson.toJson(templateFile);
		
		try {
			FileWriter file = new FileWriter("");
			file.write(json);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
