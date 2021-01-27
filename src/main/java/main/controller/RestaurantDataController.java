package main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import main.model.Restaurant;
import main.service.APICallService;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1")
public class RestaurantDataController {

	@GetMapping(path = "/getRestaurantData")
	public List<Restaurant> data(@RequestParam(value = "lat", defaultValue = "0") double lat,
			@RequestParam(value = "lng", defaultValue = "0") double lng,
			@RequestParam(value = "meal_type", defaultValue = "lunch") String food_type) {

		List<Restaurant> list = new ArrayList<Restaurant>();


		APICallService api = new APICallService();
		String dataFromYelp = api.searchForBusinesses(lat, lng, food_type);
		
		
		//parsing the json data from yelp
		JsonObject jsonObject = JsonParser.parseString(dataFromYelp.toString()).getAsJsonObject();
		JsonArray rest_list = jsonObject.get("businesses").getAsJsonArray();
		
		
		for(int i =0; i < rest_list.size(); i++) {
			
			JsonObject restaurant = rest_list.get(i).getAsJsonObject();
			String name = restaurant.get("name").toString();
			String id = restaurant.get("id").toString();
			int review_count = restaurant.get("review_count").getAsInt();
						

			double rating = restaurant.get("rating").getAsDouble();
			
			JsonObject loc = restaurant.get("location").getAsJsonObject();
			
			String address = loc.get("address1").toString() + loc.get("address2").toString()
				+ loc.get("address3").toString();
			
			
			String city = loc.get("city").toString();
            String state = loc.get("state").toString();



			
			Restaurant r = new Restaurant(name,id,address,city,state,rating,review_count);
			list.add(r);
		}

		return list;
	}

}