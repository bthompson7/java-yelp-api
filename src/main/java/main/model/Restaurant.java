package main.model;

public class Restaurant {

	private String name;
	private String id;
	private String address;
	private double rating;
	private int num_of_reviews;
	
	public Restaurant(String name, String id, String address, double rating, int num_of_reviews) {
		
	this.name = name;
	this.id = id;
	this.address = address;
	this.rating = rating;
	this.num_of_reviews = num_of_reviews;
	
	}


	public int getNum_of_reviews() {
		return num_of_reviews;
	}

	public double getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getId() {
		return id;
	}


	
	
}
