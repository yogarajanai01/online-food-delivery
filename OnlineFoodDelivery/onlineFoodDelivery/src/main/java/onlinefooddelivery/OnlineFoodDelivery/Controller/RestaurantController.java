package onlinefooddelivery.OnlineFoodDelivery.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import onlinefooddelivery.OnlineFoodDelivery.Entity.Restaurant;
import onlinefooddelivery.OnlineFoodDelivery.service.RestaurantService;

@RestController
@CrossOrigin("http://localhost:4200")
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantservice;
	
	@PostMapping("/save/Restaurant")
	public Restaurant saveRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantservice.saveRestaurant(restaurant);
		
	}

		
	

}
