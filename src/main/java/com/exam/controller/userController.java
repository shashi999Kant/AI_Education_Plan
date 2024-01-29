package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.services.UserService;

@RestController
@RequestMapping("/api/user")
public class userController {


    @Autowired
    private UserService userService;

//    private userRepository userRepository;
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
       user.setProfile("default.png");
       
       if(user.getRole()==null)user.setRole("ROLE_USER");
       
        return  this.userService.createUser(user);
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable("userName") String uname)
    {
        System.out.println(uname);

        return this.userService.getUser(uname);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long uid)
    {
        System.out.println(uid);
         this.userService.deleteUser(uid);
    }
    
   


}
