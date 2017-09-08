package com.matera.swagger.template;

import java.util.List;

import com.matera.swagger.model.postman.InfoPostman;
import com.matera.swagger.model.postman.ItemPostman;
import com.matera.swagger.model.postman.VariablePostman;

public class PostmanTemplate {

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

}
