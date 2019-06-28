package com.concrete.categoria.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Utils {

	public String getResponse(String urlEnv) throws MalformedURLException, IOException, ProtocolException {
		String response = null;
		URL url = new URL(urlEnv);// your url i.e fetch data from .
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
		}
		InputStreamReader in = new InputStreamReader(conn.getInputStream());
		BufferedReader br = new BufferedReader(in);
		String line;

		while ((line = br.readLine()) != null) {
			response = line;
		}
		conn.disconnect();
		return response;
	}
}
