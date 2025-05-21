package com.example.Account_Service.Controller;

import com.example.Account_Service.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @GetMapping("/ping")
    public void ping() {

    }

    @PostMapping("/api/auth/signup")
    public ResponseEntity<User> signup(@Valid @RequestBody User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
