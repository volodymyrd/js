package com.gmail.volodymyrdotsenko.routing.backend.services;

import com.gmail.volodymyrdotsenko.routing.backend.domain.users.User;
import com.gmail.volodymyrdotsenko.routing.backend.domain.users.UserProfile;

import java.util.Optional;
import java.util.Set;

/**
 * Created by Volodymyr Dotsenko on 12/26/16.
 */
public interface UserService {
    Optional<User> findById(Long id);

    Set<UserProfile> findProfilesByUserId(Long id);
}
