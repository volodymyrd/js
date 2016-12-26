package com.gmail.volodymyrdotsenko.routing.backend.repositories.users;

import com.gmail.volodymyrdotsenko.routing.backend.domain.users.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByEmail(String email);

    @Query("SELECT u FROM User u INNER JOIN FETCH u.roles WHERE u.email=?1")
    Optional<User> findOneByEmailWithRoles(String email);

    @Query("SELECT u FROM User u INNER JOIN FETCH u.roles WHERE u.userName=?1")
    Optional<User> findOneByUserNameWithRoles(String userName);

    @Query("SELECT COUNT(u) FROM User u WHERE u.email=?1")
    Long countByEmail(String email);

    @Query("SELECT COUNT(u) FROM User u WHERE u.userName=?1")
    Long countByUserName(String userName);

    List<User> findAllBy(Pageable pageable);
}
