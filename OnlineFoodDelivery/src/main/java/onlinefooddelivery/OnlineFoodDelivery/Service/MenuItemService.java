package onlinefooddelivery.OnlineFoodDelivery.Service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import onlinefooddelivery.OnlineFoodDelivery.DAO.MenuItemDAO;
import onlinefooddelivery.OnlineFoodDelivery.DAO.RestaurantDAO;
import onlinefooddelivery.OnlineFoodDelivery.Entity.MenuItem;
import onlinefooddelivery.OnlineFoodDelivery.Entity.Restaurant;
@Service 
public class MenuItemService {
	@Autowired 
	private MenuItemDAO menuItemdao;
	@Autowired private RestaurantDAO restaurantDAO;


	//@Transactional
	public MenuItem saveMenuItem(MenuItem menuItem) {
	    // ✅ Ensure restaurant ID exists
	    if (menuItem.getRestaurant() == null || menuItem.getRestaurant().getId() == 0) {
	        throw new RuntimeException("Restaurant ID is missing!");
	    }

	    // ✅ Fetch restaurant from database instead of saving it every time
	    Restaurant existingRestaurant = restaurantDAO.findById(menuItem.getRestaurant().getId())
	        .orElseThrow(() -> new RuntimeException("Restaurant not found"));

	    menuItem.setRestaurant(existingRestaurant); // Set the valid restaurant
	    
	    menuItem.setId(0);
	    
	    return menuItemdao.save(menuItem);
	}

	
	


	public MenuItem updateMenuItem(MenuItem menuItem) {
		menuItemdao.findById(menuItem.getId()).orElseThrow(null);
		return menuItemdao.save(menuItem);
	}


	public void deleteMenuItem(MenuItem id) {
		menuItemdao.delete(id);
		
	}

	public List<MenuItem> getmenuItems() {
		List<MenuItem> menuItems=new ArrayList<MenuItem>();
		menuItemdao.findAll().forEach(menuItems::add);
		return menuItems;
	}





	public List<MenuItem> findByRestaurantId(Long restaurantId) {
		// TODO Auto-generated method stub
		return menuItemdao.findByRestaurantId(0);
	}
	

}
