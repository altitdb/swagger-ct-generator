package com.matera.swagger.model.postman;

import java.util.List;

public class Postman {

	private List<Variable> variables;

	private InfoPostman info;

	private List<Item> item;

	public List<Variable> getVariables() {
		return variables;
	}

	public void setVariables(List<Variable> variables) {
		this.variables = variables;
	}

	public InfoPostman getInfo() {
		return info;
	}

	public void setInfo(InfoPostman info) {
		this.info = info;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

}
