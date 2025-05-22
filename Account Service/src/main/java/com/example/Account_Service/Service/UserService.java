package com.example.Account_Service.Service;

import com.example.Account_Service.Model.User;
import com.example.Account_Service.Model.UserAdapter;
import com.example.Account_Service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return user;
    }

    public Map<String, String> changePassword(String password) {
        UserDetails userDetails = (UserAdapter) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findUserByEmail(userDetails.getUsername()).orElseThrow();

        if (passwordEncoder.matches(password, user.getPassword()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The passwords must be different!");

        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        Map<String, String> response = new HashMap<>();
        response.put("email", user.getEmail());
        response.put("status", "The password has been updated successfully");

        return response;
    }
}
