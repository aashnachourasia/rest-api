package com.example.userinfoapi.repository;

import com.example.userinfoapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
}
