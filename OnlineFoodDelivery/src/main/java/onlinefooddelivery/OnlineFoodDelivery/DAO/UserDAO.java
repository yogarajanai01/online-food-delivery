package onlinefooddelivery.OnlineFoodDelivery.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import onlinefooddelivery.OnlineFoodDelivery.Entity.User;
@Repository
public interface UserDAO extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);
	
	Optional<User> findById(Long id);

}
