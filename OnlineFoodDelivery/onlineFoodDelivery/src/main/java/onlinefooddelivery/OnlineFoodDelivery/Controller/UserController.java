package onlinefooddelivery.OnlineFoodDelivery.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import onlinefooddelivery.OnlineFoodDelivery.Entity.User;
import onlinefooddelivery.OnlineFoodDelivery.service.Userservice;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	Userservice userservice;
	
	@GetMapping("/api")
	public String SayHello() {
		return "hii springboot..!";
	} 
	//get all users
	@GetMapping("/getuser")
	public List<User> getUser(){
		
		return userservice.getUsers();
	}
	
	// Register a new user
    @PostMapping("/register/user")
    public ResponseEntity<User>registeruser(@Validated @RequestBody User user){
    	Optional<User> exitingUser=userservice.getuserfindByemailId(user.getEmail());
    	if(exitingUser.isPresent()) {
    		return ResponseEntity.badRequest().body(null);
    	}
    	User createdUser=userservice.saveEmployee(user);
    	return ResponseEntity.ok(createdUser);
    }
    //login a user
    @PostMapping("/login/user")
    public ResponseEntity<String> loginUser(@RequestBody User loginRequest) {
        Optional<User> empOpt = userservice.getUserByemail(loginRequest.getEmail());
        if (empOpt.isEmpty()) {
            return ResponseEntity.status(401).body("User not found");
        }

        User user = empOpt.get();

        // Check if password matches
        if (user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
    //delete account
    @DeleteMapping("/Delete/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
	    boolean deleted = userservice.deleteUser(id);
	    return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
    //update a account
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userservice.updateUser(id, user);
    }
    
	

}
