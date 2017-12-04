package sg.edu.nus.iss.team12.service;

import sg.edu.nus.iss.team12.model.User;

public interface UserService {
	
	void save(User user);
	User findByUsername(String username);

}
