package com.gmail.volodymyrdotsenko.routing.backend.services;

import com.gmail.volodymyrdotsenko.routing.backend.domain.users.User;
import com.gmail.volodymyrdotsenko.routing.backend.domain.users.UserProfile;
import com.gmail.volodymyrdotsenko.routing.backend.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * Created by Volodymyr Dotsenko on 12/26/16.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.of(userRepository.findOne(id));
    }

    @Override
    public Set<UserProfile> findProfilesByUserId(Long id) {
        return userRepository.getOne(id).getProfiles();
    }
}
