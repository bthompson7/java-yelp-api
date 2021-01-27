package main.controller;

import java.time.LocalDate;
import java.util.Calendar;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import main.model.Restaurant;
import main.model.RestaurantDetails;
import main.service.APICallService;
import main.utils.getCurrentDay;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1")
public class RestaurantDetailsController {

	@GetMapping(path = "/getSingleRestaurant")
	public RestaurantDetails data(@RequestParam(value = "id", defaultValue = "BwJnhjN-ogCmvYY864Lkww") String rest_id) {

		APICallService api = new APICallService();
		String dataFromYelp = api.getSingleBusinessDetails(rest_id);

		JsonObject restaurant = JsonParser.parseString(dataFromYelp.toString()).getAsJsonObject();

		String name = restaurant.get("name").getAsString();
		String phone = restaurant.get("display_phone").getAsString();

		String overall_rating = restaurant.get("rating").getAsString() + " based on " + restaurant.get("review_count")
				+ " reviews";

		String price = "n/a";

		// sometimes the prices we get from the yelp api are null, I have no idea why
		if (restaurant.get("price") != null) {
			price = restaurant.get("price").getAsString();
		}

		JsonObject loc = restaurant.get("location").getAsJsonObject();

		String location = loc.get("address1").getAsString() + " ";

		String city = loc.get("city").getAsString();
		String state = loc.get("state").getAsString();
		// address2 and address3 are really only used
		// when a restaurant is in a building number
		// like => 123 Main Street building A suite 3 or something like that
		// it's more of an edge case
		if (!loc.get("address2").isJsonNull()) {
			location += loc.get("address2").getAsString();
		} else if (!loc.get("address3").isJsonNull()) {
			location += loc.get("address3").getAsString();

		}

		// get the business hours based on the current day
		String dayOfWeek = LocalDate.now().getDayOfWeek().name();

		getCurrentDay current = new getCurrentDay();
		int day = current.dayOfWeekToInt(dayOfWeek.toLowerCase());

		JsonElement hours = restaurant.get("hours");
		JsonElement times = hours.getAsJsonArray().get(0).getAsJsonObject().get("open").getAsJsonArray().get(day);

		String open_time = times.getAsJsonObject().get("start").getAsString();
		String close_time = times.getAsJsonObject().get("end").getAsString();

		// photos
		String[] photos = new String[restaurant.get("photos").getAsJsonArray().size()];

		for (int i = 0; i < restaurant.get("photos").getAsJsonArray().size(); i++) {
			photos[i] = restaurant.get("photos").getAsJsonArray().get(i).getAsString();

		}

		boolean is_open_now = hours.getAsJsonArray().get(0).getAsJsonObject().get("is_open_now").getAsBoolean();
		
		JsonElement cords = restaurant.get("coordinates");
		double lat = cords.getAsJsonObject().get("latitude").getAsDouble();
		double lng = cords.getAsJsonObject().get("longitude").getAsDouble();

		return new RestaurantDetails(name, phone, overall_rating, price,
				location, city, state, open_time, 
				close_time,is_open_now, photos, lat, lng);
	}

}
