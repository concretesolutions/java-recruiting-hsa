package com.example.servicioAPI.base;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;


public class ClienteHttp implements Serializable {
	private static final long serialVersionUID = 174901276189241064L;
	public static String runRequestByPost(String urlStr, String message, String mediaType) {
		try {
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", mediaType);

			OutputStream os = conn.getOutputStream();
			if(message!=null)
				os.write(message.getBytes());
			os.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			while ((output = br.readLine()) != null) {
				break;
			}

			conn.disconnect();
			return output;

		} catch (Exception e) {
			return null;
		}
	}
	
	
	public static String runRequestByGet(String urlStr){
		String output = null;
		try {			
			URL url = new URL(urlStr);		
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");		
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));				
				while ((output = br.readLine()) != null) {
					break;
				}
				conn.disconnect();
				
			}
		} catch (Exception e) {
		}
		return output;
	}
}