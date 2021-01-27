package main.model;

public class RestaurantDetails {

	

	private String name;
	private String phone;
	private String overall_rating;
	private String price;
	private String location;
	private String open_time;
	private String close_time;
	private String city;
	private String state;
	private boolean is_open_now;

	private double lat;
	private double lng;
	private String[] photos;
	
	/**
	 * @param name
	 * @param phone
	 * @param overall_rating
	 * @param price
	 * @param location
	 * @param hours
	 * @param photos
	 * @param lat
	 * @param lng
	 */
	public RestaurantDetails(String name, String phone, String overall_rating, 
			String price, String location,  String city, String state, String open_time, String close_time, 
			boolean is_open_now, String[] photos, double lat, double lng) {
		
		this.name = name;
		this.phone = phone;
		this.overall_rating = overall_rating;
		this.price = price;
		this.location = location;
		this.city = city;
		this.state = state;
		this.open_time = open_time;
		this.close_time = close_time;
		this.is_open_now = is_open_now;
		this.photos = photos;
		this.lat = lat;
		this.lng = lng;
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

	public double getLat() {
		return lat;
	}

	public double getLng() {
		return lng;
	}

	public String getName() {
		return name;
	}

	public String[] getPhotos() {
		return photos;
	}

	public String getOpen_time() {
		return open_time;
	}


	public String getClose_time() {
		return close_time;
	}

	public boolean isIs_open_now() {
		return is_open_now;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}





}
