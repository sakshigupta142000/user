package com.jwtuser.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class CustomerUserDetails implements UserDetails {

    private User user;

    public CustomerUserDetails(User user) {
//        System.out.println("---------------------------------------------------------");
        System.out.println(user);
        this.user = user;
    }

//    public void setUser(User user){
//        this.user=user;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(user.getProfile());
        return Arrays.asList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
/// need to change all true as user.isstatus
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
