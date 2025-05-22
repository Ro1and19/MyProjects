package com.example.Account_Service.Service;

import com.example.Account_Service.Model.User;
import com.example.Account_Service.Model.UserAdapter;
import com.example.Account_Service.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository repository;

    public MyUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository
                .findUserByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not found"));
        return new UserAdapter(user);
    }
}
