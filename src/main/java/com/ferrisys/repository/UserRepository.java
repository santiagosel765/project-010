package com.ferrisys.repository;

import com.ferrisys.common.entity.user.User;
import com.ferrisys.common.entity.user.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmailAndStatus(String email, UserStatus status);
    Optional<User> findByUsernameAndStatus(String username, UserStatus status);

}
