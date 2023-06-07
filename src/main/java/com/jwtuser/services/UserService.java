package com.jwtuser.services;

import com.jwtuser.dto.UserRequest;
import com.jwtuser.dto.UserResponse;
import com.jwtuser.model.CustomerUserDetails;
import com.jwtuser.model.User;
import com.jwtuser.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


        final User user = this.userRepository.findByEmail(email);
        System.out.println(user);
        if(user==null)
        {
            throw new UsernameNotFoundException("User not found!!");
        }else {
            return new CustomerUserDetails(user);
        }
    }
    public User createUser(UserRequest userRequest, PasswordEncoder passwordEncoder){
        User existinguser = this.userRepository.findByEmail(userRequest.getEmail());
        if(existinguser!=null){
            throw new RuntimeException("User email is already exist");
        }
        User user =new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setStatus(true);
        user.setProfile("Developer");
        userRepository.save(user);
        return user;
    }
    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public UserResponse getUserByEmail(String email){
        return getUserResponses(userRepository.findByEmail(email));
    }
    public UserResponse getUserResponses(User user){
        UserResponse userResponse=new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setStatus(user.getStatus());
        userResponse.setEmail(user.getEmail());
        userResponse.setProfile(user.getProfile());
        return userResponse;
    }



    public List<UserResponse> getAllUserResponse(){
        Iterable<User> users=userRepository.findAll();
        List<UserResponse> userResponses=new ArrayList<>();
        for(User user: users){
            userResponses.add(getUserResponses(user));
        }
        return userResponses;
    }

}
