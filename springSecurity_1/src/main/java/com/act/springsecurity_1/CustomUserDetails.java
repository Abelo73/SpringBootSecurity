package com.act.springsecurity_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component

public class CustomUserDetails implements UserDetails {


    private User user;

    @Autowired
    private UserRepository userRepository;




    @Autowired
    public CustomUserDetails(User user) {
        super();
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
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


    public String  addUser(UserDto userDto) {
        User user1 = new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getRole(),
                userDto.getPassword()
        );

        userRepository.save(user1);
        return user.getUsername();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
