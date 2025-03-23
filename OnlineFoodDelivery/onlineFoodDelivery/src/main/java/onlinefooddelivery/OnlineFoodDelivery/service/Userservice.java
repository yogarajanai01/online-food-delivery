package onlinefooddelivery.OnlineFoodDelivery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import onlinefooddelivery.OnlineFoodDelivery.DAO.UserDAO;
import onlinefooddelivery.OnlineFoodDelivery.Entity.User;

@Service
public class Userservice {
	private static final Integer Id = null;
	@Autowired
	UserDAO userdao;
    //get all users
	public List<User> getUsers(){
		List<User> user=new ArrayList<User>();
		userdao.findAll().forEach(user::add);
		return user;
		}
	 //save employee data
			public User saveEmployee(User user) {
				return userdao.save(user);
				
			}
     //Register a user
		    public Optional<User> getuserfindByemailId(String EmailId) {
			    return userdao.findByEmail(EmailId);
			}
	//login a user
		    public Optional<User> getUserByemail(String email){
		    	return userdao.findByEmail(email);
		    }
	//delete a account
		    public boolean deleteUser(int id) {
		    	if(userdao.existsById(id)) {
		    		userdao.deleteById(id);
		    		return true;
		    	}
		    	return false;
		    }
	//update a account
		    public User updateUser(Long id, User updatedUser) {
		        Optional<User> existingUser = userdao.findById(Id);
		        if (existingUser.isPresent()) {
		            User user = existingUser.get();
		            user.setName(updatedUser.getName());
		            user.setEmail(updatedUser.getEmail());
		            user.setPassword(updatedUser.getPassword());
		            return userdao.save(user);
		        }
		        return null;
		    }


}
