package com.george.userService.services.impl;

import com.george.userService.repository.UserRepository;
import com.george.userService.services.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) {
//        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().name());
//        return new org.springframework.security.core.userdetails.User(user.getEmail(),
//                user.getPassword(),
//                Set.of(authority));
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User name not found in database"));

    }

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
