package com.example.demo.repository;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    @Query(value = "SELECT exp_date from Users where id = ?", nativeQuery = true)
    Date getExpirationDatePermById(long id);

    Optional<User> findUserByUsername(String username);
}
