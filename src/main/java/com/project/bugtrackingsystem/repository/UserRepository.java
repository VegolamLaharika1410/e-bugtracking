package com.project.bugtrackingsystem.repository;

import com.project.bugtrackingsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
    User findByUserNameAndUserPassword(String userName, String userPassword);
}
