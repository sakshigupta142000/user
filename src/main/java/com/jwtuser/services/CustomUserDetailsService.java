package com.jwtuser.services;

import com.jwtuser.model.CustomerUserDetails;
import com.jwtuser.model.User;
import com.jwtuser.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        final User user = this.userRepository.findByUsername(username);

        System.out.println("====================================");
        System.out.println(user);
        if(user==null)
        {
            throw new UsernameNotFoundException("User not found!!");
        }else {
            return new CustomerUserDetails(user);
        }


//        if(username.equals("sakshi"))
////        {
////            return new User("sakshi","sakshi123",new ArrayList<>());
////        }
////        else{
////            throw new UsernameNotFoundException("user not found !! ");
////        }


    }
}
