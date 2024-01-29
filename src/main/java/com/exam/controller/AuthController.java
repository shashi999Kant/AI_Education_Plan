package com.exam.controller;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.payload.AuthRequest;
import com.exam.payload.jwtAuthResponce;
import com.exam.repo.userRepository;
import com.exam.services.JwtService;
import com.exam.services.UserInfoService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserInfoService service;

	@Autowired
	private JwtService jwtService;


	@Autowired
	private userRepository  userRepo;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome this endpoint is not secure";
	}

	
	@PostMapping("/addNewUser")
	public String addNewUser(@Valid @RequestBody User userInfo) {
		userInfo.setProfile("default.png");

        Role role = new Role();
        role.setRoleName("ROLE_USER");
           Set<Role> s=new HashSet<>();
           s.add(role);
		
		return service.addUser(userInfo);
	}
	
	
	@PostMapping("/generateToken")
	public ResponseEntity<jwtAuthResponce> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			String generateToken = jwtService.generateToken(authRequest.getEmail());
			User user = userRepo.findByEmail(authRequest.getEmail()).get();
			
			jwtAuthResponce responce=new jwtAuthResponce();
			responce.setToken(generateToken);
			responce.setUser(user);
			
			return new ResponseEntity<jwtAuthResponce>(responce,HttpStatus.OK);
			
		} else {
			throw new UsernameNotFoundException("invalid user request !");
		}
	}



}
