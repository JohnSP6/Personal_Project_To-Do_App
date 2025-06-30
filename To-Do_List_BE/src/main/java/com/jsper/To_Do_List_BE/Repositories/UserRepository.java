package com.jsper.To_Do_List_BE.Repositories;

import com.jsper.To_Do_List_BE.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);

}

