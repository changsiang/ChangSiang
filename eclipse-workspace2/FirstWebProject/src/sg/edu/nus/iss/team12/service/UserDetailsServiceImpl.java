package sg.edu.nus.iss.team12.service;

import sg.edu.nus.iss.team12.model.*;

import java.util.HashSet;
import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.iss.team12.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
			grantedAuthorities.add(new SimpleGrantedAuthority(user.getUsergroup()));
			
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}
	
	

}
