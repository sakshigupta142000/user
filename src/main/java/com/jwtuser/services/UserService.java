package com.jwtuser.services;

import com.jwtuser.dto.UserRequest;
import com.jwtuser.model.CustomerUserDetails;
import com.jwtuser.model.User;
import com.jwtuser.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        final User user = this.userRepository.findByUsername(username);
        System.out.println(user);
        if(user==null)
        {
            throw new UsernameNotFoundException("User not found!!");
        }else {
            return new CustomerUserDetails(user);
        }
    }
    public User createUser(UserRequest userRequest){
        User user =new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setStatus(true);
        user.setProfile("Developer");
        userRepository.save(user);
        return user;
    }
    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}
