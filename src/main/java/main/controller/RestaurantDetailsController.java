package main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.model.Restaurant;
import main.service.APICallService;

@RestController
@RequestMapping(path="/api/v1")
public class RestaurantDetailsController {

	@GetMapping(path="/getSingleRestaurant")
	public Restaurant data(
			@RequestParam(value = "id", defaultValue = "BwJnhjN-ogCmvYY864Lkww") String id){
		
	
		APICallService api = new APICallService();
		String dataFromYelp = api.getSingleBusinessDetails(id);

		return new Restaurant(dataFromYelp);
	}
	
	
	

}
