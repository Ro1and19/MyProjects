package com.example.Account_Service.Validation;

import com.example.Account_Service.Repository.UserRepository;
import com.example.Account_Service.Model.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UserValidator implements ConstraintValidator<NotExists, User> {
    @Autowired
    private UserRepository repository;

    @Override
    public void initialize(NotExists annotation) {
        ConstraintValidator.super.initialize(annotation);
    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        return true;
    }
}
