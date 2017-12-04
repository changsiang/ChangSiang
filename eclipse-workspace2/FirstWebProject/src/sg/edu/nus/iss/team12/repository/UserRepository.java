package sg.edu.nus.iss.team12.repository;

import sg.edu.nus.iss.team12.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	
}
