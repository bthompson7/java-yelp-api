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
	
	/**
	 * @param lat the latitude of the business
	 * @param lng the longitude of the business
	 * @param meal_type the type of meal to seach for(lunch for example)
	 * @return
	 */
	public String searchForBusinesses(double lat, double lng,String meal_type) {
		String NEARBY_BUSINESS_API_URL = "https://api.yelp.com/v3/businesses/search"+
				"?latitude=" + lat + "&longitude=" + lng 
				+ "&term=" + meal_type + "&limit=" + RESULTS_LIMIT + "&open_now=True";

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
		
	/**
	 * @param business_id the id of the business from yelp
	 * @return
	 */
	public String getSingleBusinessDetails(String business_id) {
		String SINGLE_BUSINESS_API_URL = "https://api.yelp.com/v3/businesses/" + business_id;
		
		
				try {
					URL url = new URL(SINGLE_BUSINESS_API_URL);
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
}
