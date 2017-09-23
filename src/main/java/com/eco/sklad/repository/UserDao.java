package com.eco.sklad.repository;

import com.eco.sklad.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {
    @Query("from User u where u.username=:username")
    Optional<User> findByUserName(@Param("username") String name);

    boolean existsByPhone(String phone);

    boolean existsByEmail(String email);

    User save(User user);




}
