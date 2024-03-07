package com.fishmarket.repository;

import com.fishmarket.entity.User;
import com.fishmarket.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(@RequestParam String email);
    Optional<User> findByRole(@RequestParam String role);


}
