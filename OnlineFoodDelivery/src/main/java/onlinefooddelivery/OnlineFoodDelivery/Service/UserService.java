package onlinefooddelivery.OnlineFoodDelivery.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlinefooddelivery.OnlineFoodDelivery.DAO.UserDAO;
import onlinefooddelivery.OnlineFoodDelivery.Entity.User;

@Service
public class UserService {
	@Autowired
	UserDAO userdao;
    //Find a user by email(For login)
	public Optional<User> getUserByEmail(String email) {
		
		return userdao.findByEmail(email);
	}
    //create a new user	
	public User createUser(User user) {
		
		return userdao.save(user);
	}
	
	 public Optional<User> getUserById(Long id) {
	        return userdao.findById(id);
	    }

}
