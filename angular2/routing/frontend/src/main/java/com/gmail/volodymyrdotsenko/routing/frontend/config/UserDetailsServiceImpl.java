package com.gmail.volodymyrdotsenko.routing.frontend.config;

import com.gmail.volodymyrdotsenko.routing.backend.domain.users.User;
import com.gmail.volodymyrdotsenko.routing.backend.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepo;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {
        User user = null;

        if (userNameOrEmail.contains("@"))
            user = userRepo.findOneByEmailWithRoles(userNameOrEmail)
                    .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found",
                            userNameOrEmail)));
        else
            user = userRepo.findOneByUserNameWithRoles(userNameOrEmail)
                    .orElseThrow(() -> new UsernameNotFoundException(String.format("User with userName=%s was not found",
                            userNameOrEmail)));

        return new CurrentUser(user);
    }

    public class CurrentUser extends org.springframework.security.core.userdetails.User {
        private static final long serialVersionUID = 1L;

        private User user;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public CurrentUser(User user) {
            super(user.getEmail(), user.getPassword(), user.getRoles().stream()
                    .map(e -> new SimpleGrantedAuthority(e.getName())).collect(Collectors.toList()));

            this.user = user;
        }

    }
}
