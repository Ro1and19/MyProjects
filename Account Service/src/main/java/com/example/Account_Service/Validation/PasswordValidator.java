package com.example.Account_Service.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class PasswordValidator implements ConstraintValidator<NotBreached, String> {

    private final List<String> breachedPasswords = List.of(
            "PasswordForJanuary", "PasswordForFebruary", "PasswordForMarch", "PasswordForApril",
            "PasswordForMay", "PasswordForJune", "PasswordForJuly", "PasswordForAugust",
            "PasswordForSeptember", "PasswordForOctober", "PasswordForNovember", "PasswordForDecember");

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return !breachedPasswords.contains(password);
    }
}
