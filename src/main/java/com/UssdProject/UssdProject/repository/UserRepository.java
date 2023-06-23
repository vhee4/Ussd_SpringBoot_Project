package com.UssdProject.UssdProject.repository;

import com.UssdProject.UssdProject.models.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, Long> {
    Boolean existsByPhoneNumber(String phoneNumber);
    Boolean existsByAccountNumber(String accountNumber);
    CustomUser findByAccountNumber(String accountNumber);
}
