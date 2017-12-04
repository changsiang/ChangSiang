package sg.edu.nus.iss.team12.service;

public interface SecurityService {
	String findLoggedInUsername();
	
	void autologin(String username, String password);

}
