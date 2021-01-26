package main.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APICallService {

	//TODO hide
	String API_KEY = "fmChFJUPUIcL7nfSRgcW8mnOPLHII5qnGvzvPh9E9fr2zXck2xNVFdOWjKzCn8qTt6mkdg1INZOrCh78rmI8nDoktA9hJaBlgHYrdRbAO83z2_qMtSQzfOtdNhdlXnYx";
	String result = "";
	int RESULTS_LIMIT = 50;
	
	public APICallService() {
		
	}
	
	public String searchForBusinesses(double lat, double lng,String food_type) {
		String NEARBY_BUSINESS_API_URL = "https://api.yelp.com/v3/businesses/search"+
				"?latitude=" + lat + "&longitude=" + lng 
				+ "&term=" + food_type + "&limit=" + RESULTS_LIMIT + "&open_now=True";

		//get request here
		try {
			URL url = new URL(NEARBY_BUSINESS_API_URL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Authorization", "Bearer " + API_KEY);
			con.setRequestMethod("GET");
			
			BufferedReader in = new BufferedReader(
					  new InputStreamReader(con.getInputStream()));
					String inputLine;
					StringBuffer content = new StringBuffer();
					while ((inputLine = in.readLine()) != null) {
					    content.append(inputLine);
					}
					result = content.toString();
					in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	//TODO implement
	public String getSingleBusinessDetails(String bussiness_id) {
		String SINGLE_BUSINESS_API_URL = "";
		return "";
	}
}
