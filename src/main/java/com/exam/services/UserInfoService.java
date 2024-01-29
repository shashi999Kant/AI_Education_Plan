package com.exam.services;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.repo.userRepository;


@Service
public class UserInfoService implements UserDetailsService {

	@Autowired
	private userRepository repository;
	


	@Lazy
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> userDetail = repository.findByEmail(username);

		// Converting userDetail to UserDetails
		return userDetail.map(UserInfoDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
	}
	
	public String addUser(User userInfo) {
	    userInfo.setPassword(encoder.encode(userInfo.getPassword()));

	    // Initialize userRoles if null and add the default role "Role_USER"
	    if(userInfo.getRole()==null) {
			userInfo.setRole("ROLE_USER");
		}

	    repository.save(userInfo);

	    return "User Added Successfully";
	}
	
	


}
