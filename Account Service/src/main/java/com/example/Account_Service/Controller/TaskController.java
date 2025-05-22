package com.example.Account_Service.Controller;

import com.example.Account_Service.Model.User;
import com.example.Account_Service.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private UserService userService;

    @GetMapping("/username")
    public void username(@AuthenticationPrincipal UserDetails details) {
        System.out.println(details.getUsername());
    }

    @GetMapping("/ping")
    public String ping() {
        return "cool";
    }

    @PostMapping("/api/auth/signup")
    public ResponseEntity<User> signup(@Valid @RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

}
