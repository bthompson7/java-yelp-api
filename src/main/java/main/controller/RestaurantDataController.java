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

@CrossOrigin //probably not 100% secure but whatever LOL
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

		for (int i = 0; i < rest_list.size(); i++) {

			JsonObject restaurant = rest_list.get(i).getAsJsonObject();
			String name = restaurant.get("name").getAsString();
			String id = restaurant.get("id").getAsString();
			int review_count = restaurant.get("review_count").getAsInt();

			double rating = restaurant.get("rating").getAsDouble();

			JsonObject loc = restaurant.get("location").getAsJsonObject();

			
			String address = loc.get("address1").getAsString() + " ";
			
			//address2 and address3 are really only used
			//when a restaurant is in a building number
			//like => 123 Main Street building A suite 3 or something like that
			//it's more of an edge case
			if(!loc.get("address2").isJsonNull()) {
				address += loc.get("address2").getAsString();
			}else if(!loc.get("address3").isJsonNull()) {
				address += loc.get("address3").getAsString();

			}
	
			String city = loc.get("city").getAsString();
			String state = loc.get("state").getAsString();

			Restaurant r = new Restaurant(name, id, address, city, state, rating, review_count);
			list.add(r);
		}

		return list;
	}

}