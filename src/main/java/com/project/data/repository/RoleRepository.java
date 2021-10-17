package com.project.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.data.model.UserRole;

public interface RoleRepository extends JpaRepository<UserRole, Long> {

	Optional<UserRole> findByRoleName(@PathVariable String roleName);
}
