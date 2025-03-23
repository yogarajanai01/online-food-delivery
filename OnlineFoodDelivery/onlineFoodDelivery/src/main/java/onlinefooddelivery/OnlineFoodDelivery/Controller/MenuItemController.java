package onlinefooddelivery.OnlineFoodDelivery.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
import onlinefooddelivery.OnlineFoodDelivery.Entity.MenuItem;
import onlinefooddelivery.OnlineFoodDelivery.service.MenuItemService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/menu-Items")
public class MenuItemController {
	@Autowired
	MenuItemService menuitemservice;

	@PostMapping("/add")
	public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuitem){
		return ResponseEntity.ok(menuitemservice.addMenuItem(menuitem));
		
	}
	
	@PutMapping("/updatemenu/{id}")
	public ResponseEntity<MenuItem> updateMenuItem(@PathVariable int id,@RequestBody MenuItem menuitem){
		return ResponseEntity.ok(menuitemservice.updateMenuItem(id,menuitem));
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteMenuItem(@PathVariable int id){
		menuitemservice.deleteMenuItem(id);
		return ResponseEntity.ok("Menu deleted Successfully.");
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<MenuItem>>getAllMenuItems(){
		return ResponseEntity.ok(menuitemservice.getAllMenuItems());
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<MenuItem> getMenuItemById(@PathVariable int id){
		return ResponseEntity.ok(menuitemservice.getMenuItemById(id));
	}
	
	@GetMapping("/restaurant/{restaurantId}")
	public ResponseEntity<List<MenuItem>>getMenusByRestaurant(@PathVariable int restaurantId){
		return ResponseEntity.ok(menuitemservice.getMenuItemsByRestaurant(restaurantId));
		
	}
}