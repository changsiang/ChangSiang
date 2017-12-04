package sg.edu.nus.iss.team12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.team12.model.User;
import sg.edu.nus.iss.team12.repository.UserRepository;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUsergroup("pending");
		userRepository.save(user);
		
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
