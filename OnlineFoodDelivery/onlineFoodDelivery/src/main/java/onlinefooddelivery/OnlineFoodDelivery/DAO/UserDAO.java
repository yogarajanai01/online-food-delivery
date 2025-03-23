package onlinefooddelivery.OnlineFoodDelivery.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import onlinefooddelivery.OnlineFoodDelivery.Entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>{

	// Find user by email (useful for authentication or uniqueness checks)
    Optional<User> findByEmail(String email);
    //check if email exits
    boolean existsByEmail(String email);
    //find by id
	Optional<User> findById(int Id);
	
    
    
   
}
