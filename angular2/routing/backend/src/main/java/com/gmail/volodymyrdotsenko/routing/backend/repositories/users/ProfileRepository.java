package com.gmail.volodymyrdotsenko.routing.backend.repositories.users;

/**
 * Created by Volodymyr Dotsenko on 11/27/16.
 */

import com.gmail.volodymyrdotsenko.routing.backend.domain.users.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<UserProfile, Long> {
}