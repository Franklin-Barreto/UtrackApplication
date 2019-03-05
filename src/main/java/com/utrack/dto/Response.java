package com.utrack.dto;

import java.util.ArrayList;
import java.util.List;

public class Response {
	List<DriverDTO> results = new ArrayList<>();
	
	public List<DriverDTO> getResults() {
		return results;
	}
	
	public void setResults(List<DriverDTO> results) {
		this.results = results;
	}
}
