package onlinefooddelivery.OnlineFoodDelivery.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import onlinefooddelivery.OnlineFoodDelivery.DAO.MenuItemDAO;
import onlinefooddelivery.OnlineFoodDelivery.Entity.MenuItem;

@Service
public class MenuItemService {
	@Autowired
	MenuItemDAO menuitemdao;
	//retrieve restaurant using id
	 public List<MenuItem> getrestaurant(int id) {
	        return menuitemdao.findByRestaurantId(id);
	    }

	@Transactional
	 public MenuItem addMenuItem(MenuItem menuitem) {
		return menuitemdao.save(menuitem);
	}
	
	public MenuItem updateMenuItem(int id,MenuItem menuitem) {
		Optional<MenuItem> existingItem = menuitemdao.findById(id);
		if(existingItem.isPresent()) {
			MenuItem updatedItem = existingItem.get();
			updatedItem.setName(menuitem.getName());
			updatedItem.setPrice(menuitem.getPrice());
			updatedItem.setRestaurant(menuitem.getRestaurant());
			return menuitemdao.save(updatedItem);
		}else {
			throw new RuntimeException("menuitem not found with id: "+ id);
		}
	}
	
	public void deleteMenuItem(int id) {
		menuitemdao.deleteById(id);
	}
	 
	public List<MenuItem>getAllMenuItems(){
		return menuitemdao.findAll();
	}
	
	public MenuItem getMenuItemById(int id) {
		return menuitemdao.findById(id)
				.orElseThrow(()-> new RuntimeException("MenuItem not found with id :"+id));
	}

	public List<MenuItem> getMenuItemsByRestaurant(int restaurantId) {
		
		return menuitemdao.findByRestaurantId(restaurantId);
	}
}
