package com.matera.swagger.factory;

import com.matera.swagger.enums.Templates;
import com.matera.swagger.template.Template;
import com.matera.swagger.template.TemplateDelete;
import com.matera.swagger.template.TemplateGet;
import com.matera.swagger.template.TemplateNull;
import com.matera.swagger.template.TemplatePost;
import com.matera.swagger.template.TemplatePut;

public class TemplateFactory {

	public Template createTemplate(Templates type) {
		
		if(type == Templates.NULL){
			return new TemplateNull();
		}
		
		if(type == Templates.GET) {
			return new TemplateGet();
		}
		
		if(type == Templates.POST) {
			return new TemplatePost();
		}
		
		if(type == Templates.PUT) {
			return new TemplatePut();
		}
		
		if(type == Templates.DELETE) {
			return new TemplateDelete();
		}
		
		return null;
	}
}
