package onlinefooddelivery.OnlineFoodDelivery.Controller;

import onlinefooddelivery.OnlineFoodDelivery.Entity.MenuItem;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onlinefooddelivery.OnlineFoodDelivery.Service.MenuItemService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MenuItemController {
	@Autowired 
	private MenuItemService menuItemService;
	//add a menu
	@PostMapping("/save/menu")
	public ResponseEntity<MenuItem> saveMenu(@RequestBody MenuItem menuitem){
		return ResponseEntity.ok(menuItemService.saveMenuItem(menuitem));
		
	}
	
	@GetMapping("/get/menu")
	public List<MenuItem> getMenuItems()
	{
		return menuItemService.getmenuItems();
		
	}
    
	
	//Get menu by using restaurant id
	@GetMapping("/get/{restaurantId}")
	public List<MenuItem> getMenuByRestaurant(@PathVariable Long restaurantId)
	{
		return menuItemService.findByRestaurantId(restaurantId);
		
	}
	@PutMapping("/update/menu")
	public ResponseEntity<MenuItem> updateMenuItem(@RequestBody MenuItem menuItem)
	{
		MenuItem updatedMenuItem =menuItemService.updateMenuItem(menuItem);
		if(updatedMenuItem!=null)
		{
			return ResponseEntity.ok(updatedMenuItem);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}	
		
	}
	@DeleteMapping("/delete/menu/{id}")
	public void deleteMenuItem(@PathVariable int id)
	{
		menuItemService.deleteMenuItem(null);
	}

}
