package com.exam.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exception.ResourceNotFoundException;
import com.exam.model.User;
import com.exam.repo.roleRepository;
import com.exam.repo.userRepository;
import com.exam.services.UserService;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private userRepository userRepository;

    @Autowired
    private roleRepository roleRepository;
    @Override
    public User createUser(User user) throws Exception {

        User local =this.userRepository.findByUserName(user.getUserName())
           		.orElseThrow(() -> new ResourceNotFoundException("user", "id " , user.getId()));

        if(local !=null)
        {
            System.out.println("User already present");
            throw  new Exception("User already present");
        }
        else
        {
            
            local=this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String uname) {
        return this.userRepository.findByUserName(uname).get();
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long userId) {
		// TODO Auto-generated method stub
		return this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user ", "id", userId));
	}



}
