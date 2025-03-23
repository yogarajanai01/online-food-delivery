package onlinefooddelivery.OnlineFoodDelivery.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import onlinefooddelivery.OnlineFoodDelivery.Entity.Restaurant;
import onlinefooddelivery.OnlineFoodDelivery.Service.RestaurantService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestaurantController {
	@Autowired 
	private RestaurantService restaurantService;
	
	@PostMapping("/save/restaurant")
	public Restaurant addRestaurant(@RequestBody Restaurant restaurant)
	{
		return restaurantService.saveRestaurant(restaurant);
		
	}
	
	//Get all restaurants
	@GetMapping ("/get/restaurant")
	public List<Restaurant> getAllRestaurants()
	{
		return restaurantService.getAllRestaurants();
		
	}
	@GetMapping("/get/restaurant/{Id}")
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long Id) {
		Restaurant restaurant =restaurantService.getRestaurantById(Id);
		if(restaurant != null) {
			return ResponseEntity.ok(restaurant);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
