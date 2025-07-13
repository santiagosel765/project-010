package com.ferrisys.repository;

import com.ferrisys.common.entity.user.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatusRepository extends JpaRepository<UserStatus, Integer> {
}