package com.sutanrrier.desafiospring.headers;

import org.springframework.http.HttpHeaders;

public class MyHeaders {
	public static HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Access-Control-Allow-Origin", "http://127.0.0.1:5500/frontend/pages/cadastrarCarro.html");
		headers.set("Access-Control-Allow-Credentials", "true");
		return headers;
	}
}
