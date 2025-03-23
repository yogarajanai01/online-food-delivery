package onlinefooddelivery.OnlineFoodDelivery.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import onlinefooddelivery.OnlineFoodDelivery.Entity.User;
import onlinefooddelivery.OnlineFoodDelivery.Service.UserService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	 private UserService userService;
	
	//Register a new user
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Validated @RequestBody User user)
	{
		Optional<User> existingUser = userService.getUserByEmail(user.getEmail());
		if(existingUser.isPresent())
		{
			return ResponseEntity.badRequest().body(null);//User with this email already exist
		}
		User createdUser =userService.createUser(user);		
		return ResponseEntity.ok(createdUser);		
	}
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody User loginRequest)
	{
		 Optional<User> userOpt = userService.getUserByEmail(loginRequest.getEmail());
	        if (userOpt.isEmpty()) {
	            return ResponseEntity.status(401).body("User not found");
	        }

	        User user = userOpt.get();
	        if (user.getPassword().equals(loginRequest.getPassword())) {
	            return ResponseEntity.ok("Login successful");
	        } else {
	            return ResponseEntity.status(401).body("Invalid credentials");
	        }		
	}
	 // Create a new user (for demonstration purposes)
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Validated @RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }
	
}
