package onlinefooddelivery.OnlineFoodDelivery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import onlinefooddelivery.OnlineFoodDelivery.DAO.RestaurantDAO;
import onlinefooddelivery.OnlineFoodDelivery.Entity.Restaurant;

@Service
public class RestaurantService {

	@Autowired
	RestaurantDAO restaurantdao;
	
	@Transactional
	// save restaurant
	public Restaurant saveRestaurant(Restaurant restaurant) 
	{
		return restaurantdao.save(restaurant);
		
	}
}