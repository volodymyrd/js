package com.gmail.volodymyrdotsenko.routing.backend.repositories.users;

/**
 * Created by Volodymyr Dotsenko on 11/27/16.
 */

import com.gmail.volodymyrdotsenko.routing.backend.domain.users.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByName(String name);
}