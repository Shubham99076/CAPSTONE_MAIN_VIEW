package com.project.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.data.model.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Long> {

	Optional<UserInfo> findByUnameIgnoreCaseAndPassword(@PathVariable String name, @PathVariable String password);
}
