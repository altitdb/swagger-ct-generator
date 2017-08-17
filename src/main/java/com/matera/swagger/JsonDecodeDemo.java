package com.matera.swagger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDecodeDemo {

	public static void main(String[] args) throws IOException {
		String json = new String(Files.readAllBytes(Paths.get("C:\\users\\altitdb\\Desktop\\ibk_edge.json")));
		JSONParser parser = new JSONParser();

		try {
			JSONObject jsonObject = (JSONObject) parser.parse(json);
			String basePath = (String) jsonObject.get("basePath");
			JSONObject paths = (JSONObject) jsonObject.get("paths");
			Set<String> urlDomain = new TreeSet<String>();
			Set<String> headerDomain = new TreeSet<String>();
			Set<String> pathDomain = new TreeSet<String>();
			Set<String> queryDomain = new TreeSet<String>();
			Set<String> bodyDomain = new TreeSet<String>();
			for (Object key : paths.keySet()) {
				urlDomain.add(basePath + key);
				JSONObject object = (JSONObject) paths.get(key);
				JSONArray array = (JSONArray) object.get("parameters");
				if (array != null) {
					pathDomain.addAll(handleDomain(array, "path"));
				}
				JSONObject get = (JSONObject) object.get("get");
				if (get != null) {
					JSONArray arrayParameters = (JSONArray) get.get("parameters");
					if (arrayParameters != null) {
						queryDomain.addAll(handleDomain(arrayParameters, "query"));
						headerDomain.addAll(handleDomain(arrayParameters, "header"));
					}
				}		
				JSONObject post = (JSONObject) object.get("post");
				if (post != null) {
					JSONArray arrayParameters = (JSONArray) post.get("parameters");
					if (arrayParameters != null) {
						queryDomain.addAll(handleDomain(arrayParameters, "query"));
						headerDomain.addAll(handleDomain(arrayParameters, "header"));
						bodyDomain.addAll(handleDomain(jsonObject, arrayParameters));
					}
				}
				JSONObject delete = (JSONObject) object.get("delete");
				if (delete != null) {
					JSONArray arrayParameters = (JSONArray) delete.get("parameters");
					if (arrayParameters != null) {
						queryDomain.addAll(handleDomain(arrayParameters, "query"));
						headerDomain.addAll(handleDomain(arrayParameters, "header"));
						bodyDomain.addAll(handleDomain(jsonObject, arrayParameters));
					}
				}
			}
			System.out.println("URLs Domain " + urlDomain);
			System.out.println("Headers Domain " + headerDomain);
			System.out.println("Paths Domain " + pathDomain);
			System.out.println("Queries Domain " + queryDomain);
			System.out.println("Bodies Domain " + bodyDomain);
		} catch (ParseException pe) {
			System.out.println("position: " + pe.getPosition());
			System.out.println(pe);
			pe.printStackTrace();
		}
	}

	private static Set<String> handleDomain(JSONArray array, String type) {
		Set<String> pathsDomain = new HashSet<String>();
		array.stream().filter(json -> ((JSONObject) json).get("in").equals(type))
				.forEach(i -> pathsDomain.add(((JSONObject) i).get("name").toString()));
		return pathsDomain;
	}
	
	private static Set<String> handleDomain(JSONObject jsonObject, JSONArray array) {
		Set<String> pathsDomain = new HashSet<String>();
		Optional findFirst = array.stream().filter(json -> ((JSONObject) json).get("in").equals("body"))
		.findFirst();
		if (findFirst.isPresent()) {
			JSONObject object = (JSONObject) findFirst.get();
			JSONObject schema = (JSONObject) object.get("schema");
			String definitionName = schema.toString().split("/")[2].replaceAll("\"\\}", "");
			JSONObject definitions = (JSONObject) jsonObject.get("definitions");
			JSONObject definition = (JSONObject) definitions.get(definitionName);
			JSONObject properties = (JSONObject) definition.get("properties");
			for (Object key : properties.keySet()) {
				JSONObject keyObject = (JSONObject) properties.get(key);
				if (keyObject.get("$ref") != null) {
					String newKey = keyObject.get("$ref").toString().split("/")[2];
					JSONObject definition2 = (JSONObject) definitions.get(newKey);
					JSONObject properties2 = (JSONObject) definition2.get("properties");
					for (Object key2 : properties2.keySet()) {
						pathsDomain.add(key2.toString());
					}
				} else {
					pathsDomain.add(key.toString());
				}
			}
		}
		return pathsDomain;
	}
}