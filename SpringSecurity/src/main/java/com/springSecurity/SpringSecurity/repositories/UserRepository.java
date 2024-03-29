package com.springSecurity.SpringSecurity.repositories;

import com.springSecurity.SpringSecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

   Optional<User> findByUserEmail(String userEmail);
}
