package main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.model.Restaurant;
import main.service.APICallService;

@RestController
@RequestMapping(path="/api/v1")
public class RestaurantDataController {

	@GetMapping(path="/getRestaurantData")
	public Restaurant data(
			@RequestParam(value = "lat", defaultValue = "0") double lat,
			@RequestParam(value = "lng", defaultValue = "0") double lng,
			@RequestParam(value = "food_type", defaultValue="lunch") String food_type){
		
	
		APICallService api = new APICallService();
		String dataFromYelp = api.searchForBusinesses(lat,lng,food_type);

		return new Restaurant(dataFromYelp);
	}
	
	
	

}