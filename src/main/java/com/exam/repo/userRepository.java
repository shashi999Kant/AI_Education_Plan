package com.exam.repo;

import com.exam.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User,Long> {

	 Optional<User> findByUserName(String username);

	 Optional<User> findByEmail(String username);
}
