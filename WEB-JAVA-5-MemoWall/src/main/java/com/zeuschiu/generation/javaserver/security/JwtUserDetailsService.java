package com.zeuschiu.generation.javaserver.security;

import java.util.ArrayList;
import java.util.Optional;

import com.zeuschiu.generation.javaserver.modules.UserRepository;
import com.zeuschiu.generation.javaserver.modules.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDb userDb=userRepository.findByUsernameNative(username);
        return new User(userDb.getUsername(),userDb.getPassword(),new ArrayList<>());
    }
    public UserDb save(UserDb user) {
        UserDb newUser = new UserDb();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(newUser);
    }
}