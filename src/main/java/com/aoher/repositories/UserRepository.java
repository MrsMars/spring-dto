package com.aoher.repositories;

import com.aoher.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUserId(int userId);
}
