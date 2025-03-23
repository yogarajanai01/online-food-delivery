package onlinefooddelivery.OnlineFoodDelivery.Service;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import onlinefooddelivery.OnlineFoodDelivery.DAO.RestaurantDAO;

import onlinefooddelivery.OnlineFoodDelivery.Entity.Restaurant;
@Service 
public class RestaurantService {
	@Autowired
	private RestaurantDAO restaurantdao;	
    
	public List<Restaurant> getAllRestaurants() {
		List<Restaurant> restaurants =new ArrayList<Restaurant>();
		restaurantdao.findAll().forEach(restaurants::add);;
		//System.out.println("Fetched from DB: "+restaurants);
		return restaurants;
	}
	//Row was updated or deleted by another transaction (or unsaved-value mapping was incorrect)
    @Transactional
	public Restaurant saveRestaurant(Restaurant restaurant) {
		restaurant.setId(null);
		return restaurantdao.save(restaurant);
	}
	
	public Restaurant getRestaurantById(Long Id) {
		Optional<Restaurant> restaurant =restaurantdao.findById(Id);
		return restaurant.orElse(null);// Return restaurant or null if not found
	}

} 
