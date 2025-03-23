package onlinefooddelivery.OnlineFoodDelivery.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onlinefooddelivery.OnlineFoodDelivery.Entity.CartItem;
import onlinefooddelivery.OnlineFoodDelivery.service.cartService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cart")
public class cartController {
	@Autowired
	private cartService cartservice;
	
	@PostMapping("/add/Cart")
	public ResponseEntity<CartItem>addtoCart(@RequestBody CartItem cartitem){
		return ResponseEntity.ok(cartservice.addtoCart(cartitem));
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<CartItem>>getCartByUser(@PathVariable int userId){
		return ResponseEntity.ok(cartservice.getCartItemsByUser(userId));
	}
	
	@DeleteMapping("/remove/{cartItemId}")
	public ResponseEntity<String>removecartItem(@PathVariable int cartItemId){
		cartservice.removeCartItem(cartItemId);
		return ResponseEntity.ok("cart Item removed Successfully.");
		
	}
}
