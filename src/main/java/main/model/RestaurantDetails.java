package main.model;

public class RestaurantDetails {

	

	private String phone;
	private String overall_rating;
	private String price;
	private String location;
	private String hours;
	private double lat;
	private double lng;
	
	public RestaurantDetails(String phone, String overall_rating, String price, String location, String hours,
			double lat, double lng) {
	}
	
	public String getPhone() {
		return phone;
	}

	public String getOverall_rating() {
		return overall_rating;
	}

	public String getPrice() {
		return price;
	}

	public String getLocation() {
		return location;
	}

	public String getHours() {
		return hours;
	}

	public double getLat() {
		return lat;
	}

	public double getLng() {
		return lng;
	}



}
