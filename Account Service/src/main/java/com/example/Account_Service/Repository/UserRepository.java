package com.example.Account_Service.Repository;

import com.example.Account_Service.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByEmail(String email);

    Optional<User> findUserByEmail(String username);
}
