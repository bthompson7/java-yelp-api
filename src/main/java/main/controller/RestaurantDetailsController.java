package main.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.model.Restaurant;
import main.model.RestaurantDetails;
import main.service.APICallService;

@CrossOrigin
@RestController
@RequestMapping(path="/api/v1")
public class RestaurantDetailsController {

	@GetMapping(path="/getSingleRestaurant")
	public RestaurantDetails data(
			@RequestParam(value = "id", defaultValue = "BwJnhjN-ogCmvYY864Lkww") String id){
		
	
		APICallService api = new APICallService();
		String dataFromYelp = api.getSingleBusinessDetails(id);

		return new RestaurantDetails(dataFromYelp);
	}
	
	
	

}
