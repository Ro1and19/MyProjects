package com.example.Account_Service.Controller;

import com.example.Account_Service.Repository.UserRepository;
import com.example.Account_Service.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    TaskController(UserRepository repository,
                   BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/ping")
    public String ping() {
        return "cool";
    }

    @GetMapping("/user")
    public ResponseEntity<User> get() {
        return new ResponseEntity<>(repository.findById(1L).get(), HttpStatus.OK);
    }

    @PostMapping("/api/auth/signup")
    public ResponseEntity<User> signup(@Valid @RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
