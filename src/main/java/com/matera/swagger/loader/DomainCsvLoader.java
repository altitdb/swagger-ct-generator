package com.matera.swagger.loader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.matera.swagger.model.csv.Domain;

public class DomainCsvLoader {

	private Map<String, Map<String, String>> csvDomains;
	
	public Map<String, Map<String, String>> getCsvDomains() {
		return csvDomains;
	}

	public void setCsvDomains(Map<String, Map<String, String>> csvDomains) {
		this.csvDomains = csvDomains;
	}

	public void loader(String csvFile) {
		
		if (StringUtils.isBlank(csvFile)) {
			throw new IllegalArgumentException("CsvFile cannot be null or empty.");
		}
		
		BufferedReader br = null;
		String line = "";
		String aux = "";
		
		csvDomains = new HashMap<String, Map<String, String>>();
		
		try {

			br = new BufferedReader(new FileReader(csvFile));
			
			List<Domain> domainList = new ArrayList<Domain>();

			while ((line = br.readLine()) != null) {
				
				String[] domainSplited = line.split(",");
				
				if(StringUtils.isBlank(aux) || aux.equals(domainSplited[0])) {
					
					addDomainToControlList(domainList, domainSplited[0], domainSplited[1], domainSplited[2]);
					aux = domainSplited[0];
					
				} else {
					addToCsvDomains(aux, domainList);
					aux = domainSplited[0];
					domainList.clear();
					addDomainToControlList(domainList, domainSplited[0], domainSplited[1], domainSplited[2]);
				}
			}
			
			addToCsvDomains(aux, domainList);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void addDomainToControlList(List<Domain> domainList, String domainName, String domainValue, String domainResponse) {
		Domain domain = new Domain(domainName, domainValue, domainResponse);
		domainList.add(domain);
	}
	
	private void addToCsvDomains(String domainKey, List<Domain> domainList) {
		Map<String, String> domainMap = new HashMap<String, String>();
		
		domainList.forEach(d -> {
			domainMap.put(d.getParamValue(), d.getResponse());
		});
		
		this.csvDomains.put(domainKey, domainMap);
	}

}
