package com.pe.frostchefbackend.frost.infrastructure.entity.sign_in;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String username);


    @Query("SELECT u FROM User u WHERE u.id <> :userId AND NOT EXISTS (SELECT 1 FROM User u2 JOIN u2.friends f WHERE u2.id = :userId AND f.id = u.id)")
    List<User> findSuggestionsForUser(@Param("userId") Integer userId);
}
