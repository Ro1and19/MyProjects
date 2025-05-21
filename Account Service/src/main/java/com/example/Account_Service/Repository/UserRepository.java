package com.example.Account_Service.Repository;

import com.example.Account_Service.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    public Optional<User> findUserByName(String name);
}
